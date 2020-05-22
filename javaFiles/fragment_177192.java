// constants used to populate my model
private static final Integer[] VALUES = { 1, 5, 10, 25, 50, 100, 500, 1000, 2000, 5000, 10000,
        20000, 25000, 30000, 40000, 50000, 100000, 200000, 300000, 400000, 500000, 750000,
        1000000, 2000000 };

// locale for Turkey used to get its currency
private Locale trLocale = new Locale("tr", "TR");
// currency number formatter for Turkish Lira
private NumberFormat tlFormat = NumberFormat.getCurrencyInstance(trLocale);

// my JList's model
private DefaultListModel<Integer> listModel = new DefaultListModel<>();
// create the JList with its model
private JList<Integer> jList = new JList<>(listModel);

// elsewhere in my constructor
    // populate my list model with the array values
    for (Integer value : VALUES) {
        listModel.addElement(value);
    }

    // set my JList's renderer to render the numbers as Turkish Lira
    jList.setCellRenderer(new MyCellRenderer());

    // add my list to a JScrollPane and set how many rows are visible
    jList.setVisibleRowCount(10);
    JScrollPane scrollPane = new JScrollPane(jList);