// your initial stream
Broadcaster<Object> stream = Streams.<Object>broadcast(environment);

stream
    .groupBy(o -> o.isValid())
    .flatMap(groupedStream -> {
        if (groupedStream.key()) {
            return groupedStream.map(o -> trueOperation(o));
        } else {
            return groupedStream.map(o -> falseOperation(o));
    }
    .map(o -> additionalOperations();