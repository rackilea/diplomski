...
//start input here
for(int i = 0;i < num;i++){
    System.out.print("Enter the choice (Square, Rectangle, or Circle): ");       
    int shapeType = scan.nextInt();

    if(shapeType == 1){
            System.out.print("Enter the color: ");
            String color = scan.next();
            System.out.print("Enter the side length of the square: ");
            double sideLength = scan.nextDouble();
            Square sq = new TestShapes(). new Square(color,sideLength);
            shape[i] = sq;
    }
    else if(shapeType == 2){
            System.out.print("Enter the color: ");
            String color = scan.next();
            System.out.print("Enter the length of the rectange: ");
            double length = scan.nextDouble();
            System.out.print("Enter the width of the rectange: ");
            int width = scan.nextInt();
            Rectangle rc = new TestShapes(). new Rectangle(color,length,width);
            shape[i] = rc;
    }
    else if(shapeType == 3){
            System.out.print("Enter the color: ");
            String color = scan.next();
            System.out.print("Enter the radius of the circle: ");
        double radius = scan.nextDouble();
        Circle cr = new TestShapes(). new Circle(color,radius);
        shape[i] = cr;
    }
}
//start printing here
for(int i = 0; i < num; i++){
        shape[i].print();
}
...