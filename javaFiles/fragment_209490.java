private static ArrayList<Integer> addDifference(ArrayList<Integer> list1, ArrayList<Integer> list2){
    ArrayList<Integer> tempList1 = new ArrayList<>(list1);
    for (Iterator<Integer> iterator = list2.iterator(); iterator.hasNext();) {
        Integer value = iterator.next();
        if (inList(value, tempList1)) {
            iterator.remove();
            tempList1.remove(value);
        }
    }

    for (int r = 0; r < list2.size(); r++){
        list1.add(list2.get(r));
    }

    System.out.println(list2 + " >>> " + list1);

    return list1;
}