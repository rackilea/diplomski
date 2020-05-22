List list1 = new ArrayList();
    list1.add(1);
    list1.add(2);
    List list2 = new ArrayList();
    list2.add(1);
    list2.add(2);
    List list3 = new ArrayList();
    list3.add(1);
    list3.add(2);
    list3.add(1);
    List list4 = new ArrayList();
    list4.add(1);
    list4.add(2);
    list4.add(1);
    list4.add(2);


    Set<Integer> set = new TreeSet<>();
    set.add(list1.size());
    set.add(list2.size());
    set.add(list3.size());
    set.add(list4.size());

    List<Integer> list = new ArrayList<>(set);
    int min = list.get(0);
    System.out.println(min);


    Map<List, Integer> map = new HashMap<>();

    map.put(list1,list1.size());
    map.put(list2,list2.size());
    map.put(list3,list3.size());
    map.put(list4,list4.size());



    List finalList = new ArrayList<>();

    for (Map.Entry<List, Integer> entry : map.entrySet())
    {
        if(entry.getValue().equals(min)){
            finalList.add(entry.getKey());

        }

    }


    int finalKey = new Random().nextInt(finalList.size());

    System.out.println(finalList.get(finalKey));