while ((option=...) != Options.EXIT) {
    // execute loop body when option is not EXIT
    switch (option) {
    ...
    case Options.EXIT: // <-- it can simply not reach here. not ever.
        saveData();
}