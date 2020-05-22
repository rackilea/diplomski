boolean noBreak = true;
while (whatever()) {
    if (whateverElse()) {
        noBreak = false;
        break;
    }
    doStuff();
}
if (noBreak) {
    finishUp();
}