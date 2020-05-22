public List<Integer> getList1(List<Integer> data) {
    List<Integer> list = null;
    for (Integer element: data) {
        if (element % 2 == 0) {
           if (list == null ) {
             list = new ArrayList<Integer>();
           }
           list.add(element);
        }
    }
    return list == null ? Collections.<Integer>emptyList() : list;
}