D item1= new D(1);
    D item2= new D(10);
    D item3= new D(5);

    DWrapper wrapper1 = new DWrapper(item1);
    DWrapper wrapper2= new DWrapper(item2);
    DWrapper wrapper3= new DWrapper(item3);

    List<SortableListItem<Integer>> sortableList = new  ArrayList<SortableListItem<Integer>>();
    sortableList.add(wrapper1 );
    sortableList.add(wrapper2);
    sortableList.add(wrapper3);
    Collections.sort(sortableList);