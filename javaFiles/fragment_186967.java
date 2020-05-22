void debug(Time beforeTheBug, Time afterTheBug) {
    do {
        Time pivot = between(beforeTheBug, afterTheBug);
        if (stateIsAsExceptedAt(pivot)) {
            afterTheBug = pivot;
        } else {
           beforetheBug = pivot;
        }
    } while (amountOfCodeExecutedBetween(beforeTheBug, afterTheBug) is not trivial);
}