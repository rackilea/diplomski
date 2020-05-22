public class Test {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);


        String telephoneNumber = stdin.nextLine();

        System.out.println(Pattern.matches("[0-9]{7}", telephoneNumber));


    }
}