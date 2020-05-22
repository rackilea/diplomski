try {
    ...
        .peek(p -> { if (p == null) throw new MyException(); })
    ...
} catch (MyException exc) {
    throw new MyCheckedException();
}