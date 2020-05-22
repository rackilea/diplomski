try {
    deleteResourceRetryer.call(() -> describeResource(resourceId));
} catch (ExecutionException e) {
    // should not happens, because you will retry if any exception rather
    // than ResourceNotFoundException raised in your describeResource method
} catch (RetryException e) {
    // should not happens, because my implementation of StopStrategy
    // (as it looks in this example) is effectively infinite, until target exception.
    // For sure you're free to override it to anything you want
}