public class Main {

    public static void main(String[] args) {

        String [] a = {"aaa"};
        List<String[]> values = new LinkedList<>();
        values.add(a);

        List<String[]> v2 = FXCollections.observableArrayList(values);

        String[] b = values.get(0) ;
        b[0] = "1";

        System.out.println(v2.get(0)[0]);
        System.out.println(values.get(0)[0]);
    }
}