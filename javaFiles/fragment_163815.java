System.out.println();
String s;
Scanner sc = new Scanner(System.in);
while (sc.hasNext() && !(s = sc.next()).isEmpty()) {
    if (sc.hasNextInt()) {
        int ind = sc.nextInt();
        try {
            char ch = s.charAt(ind);
            System.out.println("Character is " + ch);
        } catch (Exception e) {
            System.out.println("Bad index Error!");
        }
    }
}