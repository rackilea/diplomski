for (Element row : rows) {
    String dog = row.select('td:eq(0)').text()
    String race = row.select('td:eq(1)').text()

    data.put(dog, race)
}