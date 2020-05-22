final Shape[] shapes = new Shape[] { new Circle(5.3), new Square(2.4) };
    new Thread() {
        public void run() {
            shapes[0] = new Square(1.5);
        }
    }.start();
    whatIs(shapes[0]);