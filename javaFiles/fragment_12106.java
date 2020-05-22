public static void createGUI() {
        JFrame myframe = new JFrame("Frame");
        JButton firstButton = new JButton("Connect");

        myframe.setSize(500, 500);

        String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};

        Object[][] data = {
            {"Kathy", "Smith",
                "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
                "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
                "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
                "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
                "Pool", new Integer(10), new Boolean(false)}
        };

        JTable table = new JTable(data, columnNames);
        table.setVisible(true);

        myframe.add(table);
        myframe.pack();           // added this
        myframe.setVisible(true); // and moved this from top
    }