String str1 = "java;python;javascript;programming;Hello;World;Hello";
    String str2 = "java;python;javascript;programming;Hello;World;Hello";

    List<String> list = new ArrayList<String>();
    list.addAll(Arrays.asList(str1.split(";")));
    list.addAll(Arrays.asList(str2.split(";")));

    for (String word : list) 
        System.out.println(word + " --> " + Collections.frequency(list,word));