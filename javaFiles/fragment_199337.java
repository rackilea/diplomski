String visitDate = " 5 April 2017  ";
    DateTimeFormatter parseFormatter 
            = DateTimeFormatter.ofPattern("d MMMM uuuu", Locale.UK);
    visitDate = visitDate.trim();
    LocalDate date = LocalDate.parse(visitDate, parseFormatter);
    // reformat to the string we like
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_uu");
    visitDate = date.format(formatter);