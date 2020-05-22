do {
    try {
        System.out.println("how many times");
        stringy = scanner.next();
        if (stringy.equals("q")){
          System.exit(0);
        }
        rollnumber = Integer.parseInt(stringy);
        nigh = 2;
   }catch (Exception e) {
        System.out.println("invalid. re-enter");
        scanner.nextLine();
   }
} while (nigh == 1);