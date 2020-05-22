class A{

    private List<String> someList = new ArrayList<String>();

    @XmlElement(name = "some-tag")
    public List<String> getList() {
        return someList;
    }

    public void setSomeList(List<String> someOtherList) {
        this.someList = someOtherList;
    }
}