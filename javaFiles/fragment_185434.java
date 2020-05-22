class MyBean1 extends SuperBean<MyBean2> {
    List<MyBean2> sublist;

    List<MyBean2> getSublist() {
        return sublist;
    }
}