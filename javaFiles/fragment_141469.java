while (scanner.hasNextLine()) {
      try {
        String name = scanner.nextLine();
        String phNo = scanner.nextLine();
        String bPlan = scanner.nextLine();
        String bPackage = scanner.nextLine();

         if(scanner.hasNextDouble()){
           double tax = scanner.nextDouble();
         }else{System.out.println("Value is not Double!")}

    } catch (Exception e) {
            System.out.println("WARNING : " + e.getMessage());
    }finally {
        scanner.close();
        User users = new User(name, phNo, bPlan, bPackage, tax);
        stable.addRow(new Object[]{name, phNo, bPlan, bPackage, tax});
        list.add(users);
   }                    
}