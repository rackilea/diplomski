ArrayList<String> al = new ArrayList<>();
    al.add("The");
    al.add("End");

    HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
    hashMap.put("This is", al);

    HashMap<String, String> newHashMap = new HashMap<>();

    for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet())
    {
        newHashMap.put(entry.getKey(), entry.getValue().toString());
    }

    System.out.println(newHashMap.toString());
    //prints {This is=[The, End]}