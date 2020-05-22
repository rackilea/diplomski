void method() {
    String thisMethodCanSeeMe;

    // ...

    this.aSmallerMethod();        // <== Can pass in `thisMethodCanSeeMe`
    this.anotherSmallerMethod();  // <== if needed

    // ...
}

private void aSmallerMethod() {
    String onlyThisMethodCanSeeMe;
    // ...
}

private void anotherSmallerMethod() {
    String onlyThisSecondSmallerMethodCanSeeMe;
    // ...
}