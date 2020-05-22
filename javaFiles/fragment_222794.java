private CompletableFuture<Result> getFutureResult(final List<Instruction> instructions) {
    CompletableFuture<Result> futureResult = null;

    for (Instruction instruction : instructions) {
        if (futureResult == null) {
            futureResult = render(instruction);
        } else {
            futureResult = futureResult.handle((result, e) -> {
                if (result.isValid())
                    return result;
                else
                    return render(instruction).join();
            });
        }
    }

    return futureResult;
}