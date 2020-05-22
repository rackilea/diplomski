String[] imageTypeMandatory = new String[] {"A","F","K","I","PROOF","LAND","BANK","INVOICE"};
    Set<String> set = new HashSet<>();
    for (String s : imageTypeMandatory) set.add(s.toLowerCase());
    for(int iCopy=0;iCopy<imageTypeMandatory.length;iCopy++) {   
            set.remove(dataOne.getString(0).trim());
    }
    System.out.println(set); //or any other way to use the result