public class UpperBound {

    private int n;

    public UpperBound(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}

public class Test {

    public static void main(String[] args) {

        UpperBound upperBound = new UpperBound(10);
        int i=0;
        List<String> lis = new ArrayList<>();
        while (i < upperBound.getN()) {
            i++;
            lis.add("1");
            System.out.println(n);
            changeMaxvalue(upperBound, lis);
        }
        lis.stream().forEach(System.out::println);

    }

    private static void chengeMaxvalue(UpperBound upperBound, List<String> lis) {
        lis.add("2");
        upperBound.setN(20);
    }

}