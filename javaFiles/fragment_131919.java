listModel = new DefaultListModel();
while (rs.next()) {
        String vorname = rs.getString("Vorname");
        String nachname = rs.getString("Nachname");
        listModel.addElement(vorname + " " + nachname);
        System.out.println(vorname + "  " + nachname);
    }
//then create a list with this model
list = new JList(listModel);