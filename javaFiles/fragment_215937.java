public void set(int field, int value) {
    fields[field] = value;
    isSet[field] = true;
    areFieldsSet = isTimeSet = false;
    if (field > MONTH && field < AM_PM) {
        lastDateFieldSet = field;
    }
    if (field == HOUR || field == HOUR_OF_DAY) {
        lastTimeFieldSet = field;
    }
    if (field == AM_PM) {
        lastTimeFieldSet = HOUR;
    }
}