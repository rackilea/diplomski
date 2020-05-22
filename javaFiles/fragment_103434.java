ArrayList<Map<String, String>> childDataItem;
    //general collection for collections of elements
    ArrayList<ArrayList<Map<String, String>>> childData;

    Map<String, String> m;


    childData = new ArrayList<>();
    childDataItem = new ArrayList<>();
        m = new HashMap<>();
        m.put("phoneName", "HTC");
        m.put("phoneName1", "HTC1");
        childDataItem.add(m);
    childData.add(childDataItem);

    childDataItem = new ArrayList<>();
        m = new HashMap<String, String>();
        m.put("phoneName", "Samsung");
        childDataItem.add(m);
    childData.add(childDataItem);

    // создаем коллекцию элементов для третьей группы
    childDataItem = new ArrayList<>();
        m = new HashMap<String, String>();
        m.put("phoneName", "LG");
        childDataItem.add(m);
    childData.add(childDataItem);


    for (ArrayList<Map<String, String>> outerEntry : childData) {
       for(Map<String, String> i:outerEntry ) {
           for (String key1 : i.keySet()) {
               String value1 = i.get(key1);
               System.out.println("MyLogs (childData)value1 = " + value1);
               System.out.println("MyLogs (childData)key = " + key1);
           }
         }
    }