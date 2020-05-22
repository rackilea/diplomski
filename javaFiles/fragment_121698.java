public class A {
    private final List<Integer> privateRef = new ArrayList<>();
    private final int privateVal = 0;

    public A(List) {
        this.privateRef.addAll(this.privateRef);
    }

    public List<Integer> getList() {
        return new ArrayList<>(this.privateRef);
    }

    public int getVal() {
        return privateVal;
    }

}