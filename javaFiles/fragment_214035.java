for(int i = 0; i < 10; i++){
    Circle circle = new Circle(Math.rand() * 600, Math.rand() * 400, Math.rand() * 30 + 20);
    list.add(circle);
    switch((int)(Math.rand() * 4)){
    case 0:
        circle.setFill(Color.GREEN);
        break;
    case 1:
        circle.setFill(Color.RED);
        break;
    case 2:
        circle.setFill(Color.BLUE);
        break;
    case 3:
        circle.setFill(Color.YELLOW);
        break;
    }
}