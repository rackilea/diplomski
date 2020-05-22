class MyMain {
    void someMethod() {
        JTable table = (new Populator()).createJTable();
        add(table);
    }
}

class Populator {
    Object[][] data = {
        {" A", ""},
        {" B", ""},
        {" C", ""},
        {" D", ""},
        {" E", ""},
        {" F", ""},
        {" G", ""},
        {" H", ""},
        {" bonus", ""},
        {" Total", ""}
    };

    String[] columname = {"", ""};

    JTable createJTable() {
        JTable tabelscor = new JTable(data, columname);
        //tabelscor.setBounds(500, 120, 160, 250);
        tabelscor.setEnabled(false);

        return tabelscor;
    }
}