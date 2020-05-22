public void set(int field, int value) {
    if (isLenient() && areFieldsSet && !areAllFieldsSet) {
        computeFields();
    }
    internalSet(field, value);
    isTimeSet = false;
    areFieldsSet = false;
    isSet[field] = true;
    stamp[field] = nextStamp++;
    if (nextStamp == Integer.MAX_VALUE) {
        adjustStamp();
    }
}