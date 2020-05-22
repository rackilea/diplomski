List<String[]> table = Arrays.asList(
        new String[] { "Age", "Name", "Sex"    },
        new String[] { "23" , "John", "Male"   },
        new String[] { "19" , "Sam" , "Female" },
        new String[] { "18" , "Alex", "Male"   } );

XMLStreamWriter xml = XMLOutputFactory.newFactory().createXMLStreamWriter(System.out);
xml.writeStartElement("Table");
xml.writeAttribute("name", "Database");

String[] header = table.get(0);
for (int rowNo = 1; rowNo < table.size(); rowNo++) {
    String[] row = table.get(rowNo);
    xml.writeCharacters(System.lineSeparator());
    xml.writeStartElement("Row");
    xml.writeAttribute("name", String.valueOf(rowNo));
    for (int colIdx = 0; colIdx < header.length; colIdx++) {
        xml.writeCharacters(System.lineSeparator() + "    ");
        xml.writeStartElement("Item");
        xml.writeAttribute("name", header[colIdx]);
        xml.writeCharacters(row[colIdx]);
        xml.writeEndElement(); // </Item>
    }
    xml.writeCharacters(System.lineSeparator());
    xml.writeEndElement(); // </Row>
}

xml.writeCharacters(System.lineSeparator());
xml.writeEndElement(); // </Table>
xml.close();