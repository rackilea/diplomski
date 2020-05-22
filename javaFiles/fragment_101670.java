List<Integer> list1 = new ArrayList<Integer>();
        list1.add(Integer.valueOf(1));
        list1.add(Integer.valueOf(2));
        List<Integer> list2 = new LinkedList<Integer>();
        list2.add(Integer.valueOf(1));
        list2.add(Integer.valueOf(2));
//True!
        System.out.println(list1.equals(list2));

        List<Integer> unModList1 = Collections.unmodifiableList(list1);
        List<Integer> unModList2 = Collections.unmodifiableList(list2);
//True!
        System.out.println(unModList1.equals(unModList2));

        Collection<Integer> unModColl1 = Collections.unmodifiableCollection(list1);
        Collection<Integer> unModColl2 = Collections.unmodifiableCollection(list2);
//False
        System.out.println(unModColl1.equals(unModColl2));