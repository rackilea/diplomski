do {
   System.out.println("What level is your fort?");
   Scanner sc = new Scanner(System.in);
   try {
    fortLevel = Integer.parseInt(sc.nextLine());
   } catch (NumberFormatException e) {
     System.out.println("Numbers only, 0-20");
   }

} while (fortLevel < 0 || fortLevel > 20);