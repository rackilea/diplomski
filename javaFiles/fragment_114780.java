public Object foo() {
    if (!objectExists()) {
        insertStuff();
        return stuff();
    }
    // Code for loading object...
}