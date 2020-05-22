try {
    for (int i = 0; i < 10; i++) {
        try {
            someOperationThatOftenFails();
        } catch (SomeCommonException e) {
            ...
        }
    }
} catch (SomeRareFatalException e) {
    ...
}