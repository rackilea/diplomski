public class Solution{

public static void main(String[] args) {
    System.out.println(getTimeMsOfInsert(new ArrayList()));
    System.out.println(getTimeMsOfInsert(new LinkedList()));
}

public static long getTimeMsOfInsert(List list) {
    return getInsertTime(list);
}

public static long getInsertTime(List list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
        list.add(new Object());
    }
    return System.currentTimeMillis() - start;
}
}