fun check(str: String): LocalDate? {
    var formatter = DateTimeFormatter.ofPattern("dd-MM-yy")
    val regex = Regex("\\b\\d{2}-\\d{2}-\\d{2}\\b")

    for (match in regex.findAll(str)) {
        try{
            return LocalDate.parse(match.value, formatter);
        }catch(e: DateTimeParseException) { }
    }
    return null
}