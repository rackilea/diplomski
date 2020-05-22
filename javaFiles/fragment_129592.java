String foods[] = {"Bread", "Pizza", "Cheese"};
    for (int x = 0; x <= 99; ) {
        for (int i = 0; i < 4; i++) {
            int random = (int) (Math.random() * 3);
            System.out.print(x + " - " + foods[random] + "\t\t");
             x++;
        }
        System.out.println();
    }