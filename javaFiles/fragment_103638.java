LocalDate original = dateFromId(id);
for (int i = 1; i <= count; i++) {
    LocalDate advanced = original.plusDays(i);
    int advancedId = idFromDate(advanced);
    // Use advanced
}