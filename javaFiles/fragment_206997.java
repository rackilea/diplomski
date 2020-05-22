public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    if(s.hasNextInt()) {
        int x = s.nextInt();
        System.out.println("Is an Int: " + x);
    } else if(s.hasNextDouble()) {
        double x = s.nextDouble();
        System.out.println("Is a Double:" + x);
    } else {
        String x = s.nextLine();
        System.out.println("Is A String: "  + x );
    }
}