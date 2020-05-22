public static Result match(Response rsp) throws Exception {
    Map<Boolean, List<Object>> collect = rsp.getFirstNodes().stream()
            .flatMap(firstNode -> firstNode.getSndNodes().stream()) // create stream of SndNodes
            .filter(SndNode::isValid) // filter so we only have valid nodes
            .map(node -> {
                // try to parse each node and return either the result or the exception
                try {
                    return parse(node);
                } catch (ParseException e) {
                    return e;
                }
            }) // at this point we have stream of objects which may be either Result or ParseException
            .collect(Collectors.partitioningBy(o -> o instanceof Result)); // split the stream into two lists - one containing Results, the other containing ParseExceptions

    if (!collect.get(true).isEmpty()) {
        return (Result) collect.get(true).get(0);
    }
    if (!collect.get(false).isEmpty()) {
        throw (Exception) collect.get(false).get(0); // throws first exception instead of last!
    }
    return null;
}