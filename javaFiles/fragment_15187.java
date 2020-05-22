public class Test {

    private static int n = 10;

    public static void main(String[] args) {

        int i=0;
        List<String> lis = new ArrayList<>();
        while (i<n) {
            i++;
            lis.add("1");
            System.out.println(n);
            changeMaxvalue(lis);
        }
        lis.stream().forEach(System.out::println);

    }

    private static void chengeMaxvalue(List<String> lis) {
        lis.add("2");
        n=20;
    }

}