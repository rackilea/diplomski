List<Integer> processBulkResponse(BulkResponse bulkResponse) {
    List<Integer> failures = new ArrayList<>();
    for (BulkItemResponse bulkItemResponse : bulkResponse) {
        if (bulkItemResponse.isFailed()) {
            failures.add(bulkItemResponse.getItemId());
        }
    }
    return failures;
}