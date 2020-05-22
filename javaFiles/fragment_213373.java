OUTER: for (...) {  // <--
    ...
    for (...) {
        if (...)
            break OUTER;  // <--
    }
}