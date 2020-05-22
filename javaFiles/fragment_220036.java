String text= "208:4 208:1 1049:2 3059:15 73684:10 715:15 6100:7 1129:15";

    List<Integer> topicIds = new ArrayList<Integer>();
    for (String str: text.split(" ")) {
        topicIds.add(Integer.parseInt(str.split(":")[1]));
    }