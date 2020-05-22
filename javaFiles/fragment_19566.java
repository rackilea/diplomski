private static class IntermediateResult {

    private final SndNode node;
    private final Result result;
    private final List<ParseException> exceptions;

    private IntermediateResult(SndNode node, Result result, List<ParseException> exceptions) {
        this.node = node;
        this.result = result;
        this.exceptions = exceptions;
    }

    private Result getResult() throws ParseException {
        if (result != null) {
            return result;
        }
        if (exceptions.isEmpty()) {
            return null;
        }
        // this will show all ParseExceptions instead of just last one
        ParseException exception = new ParseException(String.format("None of %s valid nodes could be parsed", exceptions.size()));
        exceptions.stream().forEach(exception::addSuppressed);
        throw exception;
    }

}

public static Result match(Response rsp) throws Exception {
    return Stream.concat(
                    Arrays.stream(new SndNode[] {null}), // adding null at the beginning of the stream to get an empty "aggregatedResult" at the beginning of the stream
                    rsp.getFirstNodes().stream()
                            .flatMap(firstNode -> firstNode.getSndNodes().stream())
                            .filter(SndNode::isValid)
            )
            .map(node -> new IntermediateResult(node, null, Collections.<ParseException>emptyList()))
            .reduce((aggregatedResult, next) -> {
                if (aggregatedResult.result != null) {
                    return aggregatedResult;
                }

                try {
                    return new IntermediateResult(null, parse(next.node), null);
                } catch (ParseException e) {
                    List<ParseException> exceptions = new ArrayList<>(aggregatedResult.exceptions);
                    exceptions.add(e);
                    return new IntermediateResult(null, null, Collections.unmodifiableList(exceptions));
                }
            })
            .get() // aggregatedResult after going through the whole stream, there will always be at least one because we added one at the beginning
            .getResult(); // return Result, null (if no valid nodes) or throw ParseException
}