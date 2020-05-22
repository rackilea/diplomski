//data stored in maps and maps added to list
    HashMap<String, String> temp = new HashMap<String, String>();
    temp.put("Name", "test1");//first column
    temp.put("Name1", "test1");//second column
    list.add(temp);

    HashMap<String, String> temp2 = new HashMap<String, String>();
    temp2.put("Name", "test2");//first column
    temp2.put("Name1", "test2");//second column
    list.add(temp2);

    String[] names = {"Name", "Name1"};
    int[] locations = {R.id.item1, R.id.item2};