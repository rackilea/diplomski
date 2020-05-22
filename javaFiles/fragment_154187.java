public static Integer max(Integer... vals) {
    Integer ret = null;
    for (Integer val : vals) {
        if (ret == null || (val != null && val > ret)) {
            ret = val;
        }
    }
    return ret;
}

public static void main(String args[]) {
    System.out.println(max(1, 2, 3, 4, 0, -1));
}