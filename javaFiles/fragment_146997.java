fun check(str: String): String? {
    var formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
    var v = str.replace(".*?(\\b\\d{2}-\\d{2}-\\d{2}\\b).*".toRegex(), "$1");
    try{
        LocalDate.parse(v, formatter);
        return v;
    }catch(e: DateTimeParseException) {
        return null;
    }
}