@Override
public <T> MapReduceResults<T> mapReduce(Query query, String inputCollectionName, String mapFunction,
        String reduceFunction, MapReduceOptions mapReduceOptions, Class<T> entityClass) {

    if (mapReduceOptions.getOutputType() == OutputType.INLINE) {
        // if output type is inline then no need to suppress results
        return super.mapReduce(query, inputCollectionName, mapFunction, reduceFunction, mapReduceOptions, entityClass);
    }

    String mapFunc = replaceWithResourceIfNecessary(mapFunction);
    String reduceFunc = replaceWithResourceIfNecessary(reduceFunction);

    DBCollection inputCollection = getCollection(inputCollectionName);

    MapReduceCommand command = new MapReduceCommand(inputCollection, mapFunc, reduceFunc,
            mapReduceOptions.getOutputCollection(), mapReduceOptions.getOutputType(), null);

    DBObject commandObject = copyQuery(query, copyMapReduceOptions(mapReduceOptions, command));

    if (logger.isDebugEnabled()) {
        logger.debug("Executing MapReduce on collection [{}], mapFunction [{}], reduceFunction [{}]",
                command.getInput(), mapFunc, reduceFunc);
    }

    CommandResult commandResult = executeCommand(commandObject);

    handleCommandError(commandResult, commandObject);

    if (logger.isDebugEnabled()) {
        logger.debug("MapReduce command result = [{}]", serializeToJsonSafely(commandObject));
    }

    return new MapReduceResults<>(new ArrayList<T>(), commandResult);
}