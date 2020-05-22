public class PersonUI {
    public static void main(String[] args) {
        String n, s;
        int b;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Skriv in ditt förnamn: ");
            n = scanner.nextLine();
            System.out.println(n); // Your name
        } while (!Person.setn(n));
        //
        do {
            System.out.println(" Skriv in ditt efternamn: ");
            s = scanner.nextLine();
            System.out.println(n + " " + s);// your surname
        } while (!Person.sets(s));

        do {
            System.out.println(" Skriv in ditt födelseår: ");
            b = scanner.nextInt();
            System.out.println(n + " " + s + " " + b);// date of birth
        } while (!Person.setb(b));

        Person p1 = new Person(n, s, b); // Name of person and date of birth
        System.out.print(p1.getName());
        System.out.print(" ");
        System.out.print(p1.getSname());
        System.out.print(" ");
        System.out.print(p1.getBirthyear());
        scanner.close();
    }
}