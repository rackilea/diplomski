FoodFactory ff = new FoodFactory();
Food f1 = ff.getFood("Fruit");
Food f2 = ff.getFood("Meat");
f1.serveFood();
f2.serveFood();
System.out.println(f1.getClass().getSuperclass().getSimpleName());
System.out.println(f1.getClass().getSimpleName());
System.out.println(f2.getClass().getSimpleName());