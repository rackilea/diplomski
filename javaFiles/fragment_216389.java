interface Block<T> {
    public int invoke(T arg1, T arg2);
}


class Test {
    public static <T> void sort(List<T> l, final Block<T> block) {
        Collections.sort(l, new Comparator<T>() {
            public int compare(T arg0, T arg1) {
                return block.invoke(arg0, arg1);
            }
        });
    }
}