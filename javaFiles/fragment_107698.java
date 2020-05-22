final LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final ArrayList<HashMap<String, String>> headerData = new ArrayList<HashMap<String, String>>();

    final HashMap<String, String> group1 = new HashMap<String, String>();
    group1.put(NAME, "OrderInfo");
    headerData.add( group1 );

    final HashMap<String, String> group2 = new HashMap<String, String>();
    group2.put(NAME, "CustomerInfo");
    headerData.add( group2);

    final ArrayList<ArrayList<HashMap<String, Object>>> childData = new ArrayList<ArrayList<HashMap<String, Object>>>();

    final ArrayList<HashMap<String, Object>> group1data = new ArrayList<HashMap<String, Object>>();
    childData.add(group1data);

    final ArrayList<HashMap<String, Object>> group2data = new ArrayList<HashMap<String, Object>>();
    childData.add(group2data);