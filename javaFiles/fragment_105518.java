class ListWrapper {

    @XmlElementWrapper(name = "wrapperList")
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }
}