public class A {
    private List<String> list = new ArrayList<String>();
    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }
    public static class B {
        // i want to update list here without making list as static
        void updList() {
            A a = new A();
            a.setList(someOtherList);
            System.out.println(a.getList());
        }
    }
}