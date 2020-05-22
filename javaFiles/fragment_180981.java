// loop just once, why
for (int i = 1; i <= 1; i++) {
    Elements table = doc.getElementsByTag("table");

    if (table.isEmpty()) {
        throw new Exception("Table is not found");
    }
    elements = table.get(0).getElementsByTag("tr");