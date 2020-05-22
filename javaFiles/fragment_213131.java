public class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        return arr2[i1.intValue()].compareTo(arr2[i2.intValue()]);
    }
}

Arrays.sort(arr1, new MyComparator());