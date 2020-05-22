void method() {
    String allThisCodeCanSeeMe;

    // ...

    {
        String onlyThisBlockCanSeeMe;
        // ...
    }

    {
        String onlyThisSecondBlockCanSeeMe;
        // ...
    }

    // ....
}