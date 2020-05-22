// I want this to return true if today is my birthday
public boolean isCurrentDayInMonthSameAsBirthDayInMonth() {
    return isSameAsToday(Calendar.DAY_OF_MONTH);
}

// I want this to return true if the month is the same as my birth month
public boolean isCurrentMonthSameAsBirthMonth() {
    return isSameAsToday(Calendar.MONTH);
}

private boolean isSameAsToday(int field){
    return Calendar.getInstance().get(field) == this.dob.get(field);
}