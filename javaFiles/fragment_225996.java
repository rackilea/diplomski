public static void main(String[] args) {
    System.out.println("Give the temperature : ");
    final Scanner sc = new Scanner(System.in);
    int temp = sc.nextInt();

    for (final Temperature t : temperatures) {
       if (t.within(temp)) {
          System.out.println(t.message());
       } 
    }
}