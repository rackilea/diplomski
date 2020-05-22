public class Test {

    boolean someCriteria = false;

    public static void main(String[] args) {
        new Test().getFirstElement();
    }


    public List<Object> getList() {

        List<Object> list = new ArrayList<Object>();
        if (someCriteria) {
            list.add("1");
        }
        return list;
    }


    public Object getFirstElement() {
        List<Object> list = getList();
        return(getList().get(0));
    }
}