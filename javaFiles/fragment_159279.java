Random generator = new Random();
    int x = generator.nextInt(100)+100;
    int y = generator.nextInt(100)+100;

    if (e.getActionCommand().equals("Draw RandomCircle")) {
        System.out.printf("x = %d y = %d\n", x, y);
        status.setText(String.format("rnd draw x:%d  y:%d ", x, y));
        int w = generator.nextInt(100) + 10;
        int h = w;
        Shape circle = new Ellipse2D.Double(x, y, w, h);
        addShape(new DrawShape(text, Color.BLACK, circle));
        int count = shapes.size(); 
        System.out.printf("objects in array: %d\n", count); 
    } else if (e.getActionCommand().equals("Draw RandomRectangle")) {
        System.out.printf("x = %d y = %d\n", x, y);