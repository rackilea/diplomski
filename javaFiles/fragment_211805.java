public class GenericType {

    public void display(Object t) {
        String msg;
        if(t instanceof String) {
            msg = "String";
        } else if (t instanceof Integer) {
            msg = "Integer";
        } else if (t instanceof Double) {
            msg = "Double";
        } else {
            msg = "Another Object";
        }

        System.out.println(msg);
    }
}