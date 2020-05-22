ArrayList<String> ar = new ArrayList();
    ar.add("UserId");  //adding item to arraylist
    ar.add("Directory");
    ar.add("Username");
    ar.add("PhoneNumber");

    // approach one using iteration 
    for (Iterator<String> it = ar.iterator(); it.hasNext(); ) {
        String f = it.next();
        if (f.equals("UserId"))
            System.out.println("UserId found");
    }

    // approach two using a colletion which supports fetching element by key 
    Map<String,String> myMap=new HashMap<>();
    for(String strg:ar){
        myMap.put(str,str);
    }

    String result=myMap.get("UserId");