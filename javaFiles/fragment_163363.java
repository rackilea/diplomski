Element dogRow = doc.select("tr:has(td:contains(dog))").first();

    int dogCellIndex = dogRow
        .select("td:contains(dog)")
        .first()
        .elementSiblingIndex();

    int otherCellIndex = dogCellIndex + 10;

    String cellValue = dogRow
        .getElementsByIndexEquals(otherCellIndex)
        .text();