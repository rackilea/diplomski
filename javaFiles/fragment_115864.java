public static void main(String[] args) throws Exception {

    List<Integer> tabRef =  Arrays.asList(10, 5, 3, 5, 2, 6);
    List<Integer> tabRef2 = Arrays.asList(12, 8, 3, 5, 6, 2);

    int matchesOnSameIndex = 0;
    int matchesButDifferentIndex = 0;

    for (int i = 0; i < tabRef.size(); i++) {
        //compare on same index, if other list has element on this index
        if (tabRef2.size() > i) {
            if (tabRef.get(i) == tabRef2.get(i)) {
                //same element on same index
                matchesOnSameIndex++;
            }
        }

        //check if value exists in other list
        if (tabRef2.contains(tabRef.get(i))) {
            //if yes, check if it is not at same position
            if (tabRef2.size() > i) {
                if (tabRef2.get(i) != tabRef.get(i)) {
                    //not same index
                    //TODO must count multiple times, if element exists multiple times?
                    matchesButDifferentIndex++;
                }else {
                    //TODO must count, if also exists on other index?
                }
            }else {
                //same position not existing, so must be on other position
                matchesButDifferentIndex++;
            }
        }
    }

    System.out.println("matchesOnSameIndex: "+matchesOnSameIndex);
    System.out.println("matchesButDifferentIndex: "+matchesButDifferentIndex);

}