static FileFilter stringFilter(String[] parameters, int expectedLength, BiPredicate<String, String> stringPredicate) throws
        BadParameterFilterException{
    String value = parameters[0];
    if(doesContainNOTSuffix(parameters.length, expectedLength, parameters[parameters.length-1])){
        return path -> !stringPredicate.test(path.getFileName().toString(), value);
    }
    return path -> stringPredicate.test(path.getFileName().toString(), value);
}