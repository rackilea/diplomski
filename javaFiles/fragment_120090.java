public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      int nickles;
      System.out.println("Deposit your Nickles.");
      nickles = in.nextInt();
      double nickles5 = nickles * 0.05;
      System.out.println("You have $" + nickles5);
}