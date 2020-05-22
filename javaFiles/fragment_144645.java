public static void InputDairy (Dairy DairyProducts[], Fruit FruitProducts[], Scanner input){ 

     System.out.println("Let's put in some DAIRY products");

     for (int i = 0; i < DairyProducts.length; i++){

         System.out.println("Enter name of DIARY product");
         String a = input.next();

         System.out.println("Enter Store where you bought DIARY product");
         String b = input.next();

         System.out.println("Enter how much you paid for DIARY product");
         String c = input.next();

         System.out.println("Enter when did you buy DIARY product");
         String d= input.next();

         DairyProducts[i].setDairyData(a,b,c,d);
   }

}