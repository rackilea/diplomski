public static LinkedList<String> getPermutationsComb2(LinkedList<LinkedList<String>> lists) {
    LinkedList<String> retList = new LinkedList<String>();

    if(lists.size() > 1) {
        LinkedList<LinkedList<String>> subLists = new LinkedList<LinkedList<String>>();
        for(int i = 1; i < lists.size(); i++) {
            subLists.add(lists.get(i));
        }
        LinkedList<String> listTails = getPermutationsComb2(subLists);
        Iterator<String> it_tail1 = lists.get(0).iterator();
        while(it_tail1.hasNext()){
            String listHead2 = it_tail1.next();
            Iterator<String> it_tail2 = listTails.iterator();
            while(it_tail2.hasNext()){
                retList.add(listHead2+","+it_tail2.next());
            }
        }
    } else {
        retList = lists.get(0);
    }
    return retList;
}