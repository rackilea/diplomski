String fruits = "Orange,Apple,Grape";
    String[] array = fruits.split(",");
    List<String> list = Arrays.asList(array);

    //Code to check the content in the List (for your understanding only)
    for(String s : list) {
        System.out.println(s);
    }