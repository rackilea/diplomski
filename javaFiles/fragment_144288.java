while (!done) {
    tmp = PinsNums[i];
    if (tmp.equals(keyPadNumsEntered)) {
        result = PinNames[i];
        loggedOn = true;
        done = true;
    } else {
        ++i;
        result = "no logon";
    }

    if (i == PinsNums.length) {
        done = true;
    }
}