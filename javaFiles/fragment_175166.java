public static List<ActionType> getLongestSequence(List<ActionType> list1, List<ActionType> list2) {
    lcsMemorize = new HashMap<Integer, List<ActionType>>();
    return getLongestSequence(list1, list2, list1.size(), list2.size());
}

public static List<ActionType> getLongestSequence(List<ActionType> list1, List<ActionType> list2, int list1index, int list2index) {

    List<ActionType> retVal = lcsMemorize.get(list1index + list2index * 1000000);

    if (retVal != null) {
        return retVal;
    } else if (list1index == 0 || list2index == 0) {
        retVal = new ArrayList<ActionType>();
    } else if (list1.get(list1index-1).equals(list2.get(list2index-1))) {
        List<ActionType> returned = getLongestSequence(list1, list2, list1index-1, list2index-1);

        retVal = new ArrayList<ActionType>(returned);
        retVal.add(list1.get(list1index-1));
    } else {
        List<ActionType> ret1 = getLongestSequence(list1, list2, list1index, list2index-1);
        List<ActionType> ret2 = getLongestSequence(list1, list2, list1index-1, list2index);

        if (ret1.size() > ret2.size()) {
            retVal = ret1;
        } else {
            retVal = ret2;
        }
    }

    lcsMemorize.put(list1index + list2index * 1000000, retVal);

    return retVal;
}