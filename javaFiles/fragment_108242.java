public void export(Population pop) {
    String select = "Select * FROM individuen ORDER BY ID";
    DBController dbc = DBController.getInstance();
    dbc.initDBConnection();

    XMLOutputFactory factory = XMLOutputFactory.newInstance();
    XMLStreamWriter writer;

    try {
        Statement stmt = DBController.connection.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        writer = factory.createXMLStreamWriter(new FileOutputStream("output.xml"));

        // Creating the XML-Header
        writer.writeStartDocument();
        // Root Element
        writer.writeStartElement("individuen");
        while (rs.next()) {

            // Element Person, encompasses the other Elements
            writer.writeStartElement("Peron");
            writer.writeAttribute("ID", rs.getString(1));

            // Element Geschlecht
            writer.writeStartElement("Geschlecht");
            writer.writeCharacters(rs.getString(2));
            writer.writeEndElement();

            // Element Alter
            writer.writeStartElement("Alter");
            writer.writeCharacters(rs.getString(3));
            writer.writeEndElement();

            // Element Alter
            writer.writeStartElement("Familienstand");
            writer.writeCharacters(rs.getString(4));
            writer.writeEndElement();

            // Element PartnerID
            writer.writeStartElement("PartnerID");
            writer.writeCharacters(rs.getString(4));
            writer.writeEndElement();

            // Element Bildungsstand
            writer.writeStartElement("Bildungsstand");
            writer.writeCharacters(rs.getString(5));
            writer.writeEndElement();

            // Closes Element Person
            writer.writeEndElement();
        }
        writer.writeEndDocument();
        writer.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (XMLStreamException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }