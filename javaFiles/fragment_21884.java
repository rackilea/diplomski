Elements tables = new Elements();
for (Element headerTR : headerRows) {
    Element tbody = doc.createElement("tbody");
    Element firstSiblingTR = headerTR.nextElementSibling();
    if (firstSiblingTR != null) {
        Element secondSiblingTR = firstSiblingTR.nextElementSibling();
        tbody.appendChild(firstSiblingTR);
        if (secondSiblingTR != null) {
            tbody.appendChild(secondSiblingTR);
        }
    }
    Element table = doc.createElement("table");
    table.appendChild(tbody);
    tables.add(table);
}