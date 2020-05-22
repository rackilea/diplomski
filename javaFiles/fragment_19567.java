private static class ParsedNode {
    private final Result result;

    private ParsedNode(Result result) {
        this.result = result;
    }
}

public static Result match(Response rsp) throws Exception {
    return rsp.getFirstNodes().stream()
            .flatMap(firstNode -> firstNode.getSndNodes().stream())
            .filter(SndNode::isValid)
            .map(node -> {
                try {
                    // will parse all nodes because of flatMap
                    return new ParsedNode(parse(node));
                } catch (ParseException e ) {
                    return new ParsedNode(null);
                }
            })
            .filter(parsedNode -> parsedNode.result != null)
            .findFirst().orElse(new ParsedNode(null)).result;
}