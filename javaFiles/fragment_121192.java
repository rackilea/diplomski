@Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("tablename")) {
            tableName = false;
        } else if (qName.equalsIgnoreCase("fieldname")) {
            fieldName = false;
        } else if (qName.equalsIgnoreCase("table")) {
            try {
                Database.database.addTable(tableNameString, fieldList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            fieldList = "";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        if (tableName) {
            tableNameString = data;
        } else if (fieldName) {
            fieldList += (data + " " + fieldType + ", ");
        }
    }