fun check(str: String): LocalDate? {
    var formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
    var v = str.replace(".*?(\\b\\d{2}-\\d{2}-\\d{2}\\b).*".toRegex(), "$1");
    try{
        return LocalDate.parse(v, formatter);
    }catch(e: DateTimeParseException) {
        return null;
    }
}