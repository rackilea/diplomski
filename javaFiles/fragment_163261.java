class A{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A() {
    }

    public A(String name) {
        this.name = name;
    }

}
List<A> aList = new ArrayList<A>();
aList.add(new A("abc"));
aList.add(new A("sda"));
aList.add(new A("aaa"));
Collections.sort(aList,new Comparator<A>() {

            public int compare(A o1, A o2) {
                return o1.getName().compareTo(o2.getName());
            }
});