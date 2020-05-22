ArrayList<String> list = new ArrayList<String>();
    ListIterator<String> iterator = list.listIterator();
    while(iterator.hasNext()){
        System.out.println(iterator.next());
        ...
        ...
        System.out.println(iterator.previous());
        if(!iterator.hasPrevious()){
            System.out.println("at start of the list");
        }else if(!iterator.hasNext()){
            System.out.println("at end of the list");
        }

    }