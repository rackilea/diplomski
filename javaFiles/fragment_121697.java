public class A {
    private List<Integer> privateRef = new ArrayList<>();
    private int privateVal = 0;

    public A(List) {
        this.privateRef.addAll(this.privateRef);
    }

    public List<Integer> getList() {
        return new ArrayList<>(this.privateRef);
    }

    public int getVal() {
        return privateVal;
    }

    public void mutate() {
        this.privateVal++;
        this.privateRef.clear();
    }

}