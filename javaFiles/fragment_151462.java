Connection connection = db.connect(db.getUrl_common_translation());
PreparedStatement ps = (PreparedStatement) connection.prepareStatement();
for (Entry<String, String> e : statements.entrySet()) {
    String query = "SELECT nm.id, nid.key, nm.name FROM " + e.getKey() + ".name" +" as nm "
            //----------------------------------------------^__________________^
            + "JOIN (" + e.getKey() + ".name_id" + " as nid) ON (nm.id = nid.id) "
            //-----------^_____________________^
            + "where nid.key like ? and nm.typeId=8 "
            + "and nm.sourceId=-1 and nm.languageCode='en'";
    ps.setString(1, e.getValue());
    ResultSet rs = ps.executeQuery(query);
    //------------------------------^^