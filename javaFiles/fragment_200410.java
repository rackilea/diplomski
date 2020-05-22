public static Set<Integer> mode2(List<Integer> list) {
    int maxFrequency = 0;
    boolean modeFound = false;
    Set<Integer> modeSet = new HashSet<>();
    Collections.sort(list);
    for (int i=0; i<list.size(); i++) {
        int number = list.get(i);
        int count = 1;
        for (; (i+count)<list.size() && list.get(i+count)==number; count++) {}
        i+=(count-1);
        if (maxFrequency!=0 && count!=maxFrequency) {
            modeFound = true;
        }
        if (count > maxFrequency) {
            modeSet.clear();
            modeSet.add (number);
            maxFrequency = count;
        }
        else if (count == maxFrequency) {
            modeSet.add(number);
        }
    }
    if (!modeFound) {
        modeSet.clear();
    }
    return modeSet;
}