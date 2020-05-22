List<List<Object>> objectList = new ArrayList<>();
    for (int j = 0; j < 2; j++) {
        objectList.add(j, new ArrayList<>());
        for (int i = 0; i < 2; i++) {
            if (i==0) objectList.get(j).add("string" + j + i);
            if (i==1) objectList.get(j).add((double) 37.8346 * j * i);
        }
    }

    System.out.println("OBJECT LIST: "+objectList);