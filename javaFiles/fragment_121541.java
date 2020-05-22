String [] string = {"city","town","country","province"};
 java.util.List<String> list = new ArrayList<String>(Arrays.asList(string));


 Object[] arrayObject= list.toArray();
 String [] data = Arrays.copyOf(arrayObject, arrayObject.length,String[].class); // java 1.6+
 JComboBox<String> combo = new JComboBox<>( data);