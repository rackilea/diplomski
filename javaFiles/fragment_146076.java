while (mealFileSC.hasNext()) {

       int i = 0;

       mealName[i] = mealFileSC.nextLine().toString();
       System.out.println(mealName[i]);
       mealPrice[i] = Double.valueOf(mealFileSC.nextLine());
       System.out.println(mealPrice[i]);

       i++;
   }