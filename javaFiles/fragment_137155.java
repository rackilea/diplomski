public class Bar {

    private int count;

    public void bar(String in) {
        System.out.println(in);
        if (count++ < 2) {
            throw new RuntimeException("foo");
        }
    }

}