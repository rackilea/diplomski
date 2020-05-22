ligne1 = emptyIfNull(lignes.item(0).getAttributes().item(0).getTextContent());
ligne2 = emptyIfNull(lignes.item(1).getAttributes().item(0).getTextContent());
ville = emptyIfNull(address.getElementsByTagName("city").item(0).getAttributes()
        .item(0).getTextContent());
pays = emptyIfNull(address.getElementsByTagName("country").item(0).getAttributes()
        .item(0).getTextContent());