LocalDate today = LocalDate.now();
if (! today.equals(lastCallDate)) {
    this.lastCallDate = today;
    callOnceDailyOneTime();
} else {
    // ...
}