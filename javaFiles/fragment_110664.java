while(true) {
    nextValue = computeNextValue(previousValue);
    if(Math.abs(previousValue - nextValue) < ERROR_THRESHOLD) {
        break;
    }
    previousValue = nextValue;
}