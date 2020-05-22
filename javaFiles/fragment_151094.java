// check if charSequence is null or empty ""
if (charSequence == null || charSequence.toString().isEmpty()) {
    numberOfYearsBirthday = 0;
} else {
    numberOfYearsBirthday = Integer.valueOf(charSequence.toString());
}