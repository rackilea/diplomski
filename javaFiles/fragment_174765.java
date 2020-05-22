public static void main(String[] args) {
    String method = "";
    while(! method.equals("tax")){
      System.out.print("What do you want to calculate? ");
      method = sc.nextLine();
    }
    tax();
  }