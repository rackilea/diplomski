while(true) {
     try {
         System.out.print("Enter: ");
         int a = scanner.nextInt();
         String b = scanner.next();
         int c = scanner.nextInt();
         String d = scanner.next();
         scanner.nextLine();
         // Some logics
     } 
     catch(Exception e) {
         System.out.println("Bad input");
         scanner.nextLine();
     }
}