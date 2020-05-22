public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Two numbers in ascending order");
     int min = sc.nextInt();
     int max = sc.nextInt();

     int ascending1 = ascending(min, max);
     System.out.println(ascending1);
}