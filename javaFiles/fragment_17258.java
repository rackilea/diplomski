public static <R extends Comparable <R>> void bubbleSort(ArrayList<R> list) {

    for (int k = 1; k < list.size();k++) {
        for (int i = 0; i <list.size()-k; i++) {   

             R elem = list.get(i);
             R elem2 = list.get(i+1);

             if (elem.compareTo(elem2) > 0) {
                 list.set(i, elem2); 
                 list.set(i+1, elem); 
             }
         }
         printList(list);

    }
}