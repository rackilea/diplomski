Scanner scanner = new Scanner(System.in);

for (int i = 0; i < arrayOfShapes.length; i++) {
        Point point;
        Square square;
        Cube cube;
        Circle circle;
        Cylinder cylinder;

        System.out.println("What Shape do you want to create?");
        System.out.println("1. Point");
        System.out.println("2. Square");
        System.out.println("3. Cube");
        System.out.println("4. Circle");
        System.out.println("5. Cylinder");
        System.out.println("Choose one:");
        int choice = scanner.nextInt();
        System.out.println("\n");
        switch (choice) {
            case 1:

                System.out.println("Please enter Coordinate 1: ");
                int x = scanner.nextDuoble();
                System.out.println(x);
                System.out.println("Please enter Coordinate 2: ");
                int y = scanner.nextDouble();
                System.out.println(y);
                point = new Point(x,y);
                arrayOfShapes[i] = point;
                System.out.println("(" + point.getX() + "," + point.getY() + ")");
                break;

        ...
        ...