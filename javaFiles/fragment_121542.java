String [] string = {"city","town","country","province"};
 java.util.List<String> list = new ArrayList<String>(Arrays.asList(string));


 JComboBox< java.util.List<String>> combo = new JComboBox<>( );
 combo.addItem(list);