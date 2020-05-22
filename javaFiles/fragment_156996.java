future.whenComplete((r, e) -> {
    try {
        localContext.close();
    } catch (Exception e2) {
        throw new RuntimeException("Failed to close context", e2);
    }
});