List<String> myList = 
      new ArrayList<>(Arrays.asList("Item 1", 
                                    "Item 2", 
                                    "Item 3", 
                                    "Item 4", 
                                    "Item 5"));

DefaultListModel model = new DefaultListModel();
JList myJList = new JList(model);