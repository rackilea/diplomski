public int compare(Article a1, Article a2) {
    // define a suitable formatter
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // parse both dates
    LocalDate ldOne = LocalDate.parse(a1.getDate(), dtf);
    LocalDate ldTwo = LocalDate.parse(a2.getDate(), dtf);
    // compare the dates and return the result
    return ldOne.compareTo(ldTwo);
}