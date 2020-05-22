BlockSegment:
if (conditionIsTrue) {
    doSomeProcessing ();
    if (resultOfProcessingIsFalse()) break BlockSegment;
    otherwiseDoSomeMoreProcessing();
    // These lines get skipped if the break statement
    // above gets executed
}
// This is where you resume execution after the break
anotherStatement();