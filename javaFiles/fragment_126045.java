public void fireTestFailure(Failure failure) {
    originalNotifier.fireTestFailure(failure);

    if (failure.getException().getClass() == AssertionError.class) {
        // Requirement issue
    } else {
        // Unit test issue
    }
}