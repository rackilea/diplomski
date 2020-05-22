public class Main {
    public static void main(String[] args) {
        // It will print the number 4 on your console
        System.out.println(new Sum(2, 2).sumMyNumbers());

        // Or like this:
        Sum mySum = new Sum(2,2);
        System.out.println(mySum.sumMyNumbers());

        // Or even like this:
        int i = new Sum(2, 2).sumMyNumbers();
        System.out.println(i);
    }
}