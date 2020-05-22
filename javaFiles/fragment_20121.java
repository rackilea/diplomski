Map<Integer, List<Expenditure>> groups = expenditures.stream().collect(Collectors.groupingBy(e -> e.getDate().getYear()));
for (Entry<Integer, List<Expenditure>> entry : groups.entrySet()) {
    thisYear = new Element("year");
    thisYear.setAttribute("y", year + "");
    entry.getValues().forEach( e -> {
        Element expenditure = new Element("Expenditure");
        expenditure.addContent(new Element("date")
                .setText(Utils.getFormattedDateTime("dd-MM-yyyy", new DateTime(e.getDate()))));
        expenditure.addContent(new Element("money").setText(e.getMonetaryAmount().toString()));
        expenditure.addContent(new Element("description").setText(e.getDescription()));
        expenditure.addContent(new Element("type").setText(e.getType().name()));
        thisYear.addContent(expenditure);
    });
    doc.getRootElement().addContent(thisYear);

}