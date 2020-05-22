public class MyObject {
    private List<?> list;
    private Class<?> type;

    public <T> void setList(List<T> list, Class<T> c) {
        this.list = list;
        this.type = c;
    }

    public List<?> getList() {
        return list;
    }

    public Class<?> getType() {
        return type;
    }
}