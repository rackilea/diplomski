System.out.println("###############");
    System.out.println("#   Welcome   #");
    System.out.println("###############");


    String vals = "2357";

    char od1 = vals.charAt((int)(Math.random() * 4));
    char od2 = vals.charAt((int)(Math.random() * 4));
    char od3 = vals.charAt((int)(Math.random() * 4));


    System.out.print("\n" + "Player" + "\n");
    System.out.println("-----------");
    System.out.print(od1 + " " + od2 + " " + od3);