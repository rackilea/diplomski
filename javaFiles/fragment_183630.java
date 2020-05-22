class Testcase {

    public <E> List<List<E>> transform(List<List<E>> list) {
        return list;
    }

    public <E> List<List<? extends E>> transform2(List<List<? extends E>> list) {
        return list;
    }

    public <E> List<? extends List<? extends E>> transform3(List<? extends List<? extends E>> list) {
        return list;
    }    

    public void test(String[] args) {
        List<List<Integer>> known = new ArrayList<>();
        List<List<? extends Number>> unknown = new ArrayList<>();

        transform(known);    // works
        // transform(unknown);  // fails

        // transform2(known);   // fails
        transform2(unknown); // works

        transform3(known);
        transform3(unknown);
    }
}