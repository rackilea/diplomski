public boolean check(String date){
    try {
        LocalDate localDate = LocalDate.parse(date);
        return true; // valid date if parsing was successful
    } catch (DateTimeParseException e) {
        e.printStackTrace();
        return false; // not a valid date
    }
}