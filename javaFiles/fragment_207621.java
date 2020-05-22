public class MyBean {
    private String name;
    private String value;
    private List<MyBean> beanList = new ArrayList<>();

    public MyBean(String name, String value, MyBean previous) {
        this.name = name;
        this.value = value;
        if (previous != null)
            this.beanList.add(previous);
    }

    //getters & setters
}