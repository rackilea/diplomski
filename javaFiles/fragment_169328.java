public static void main(String[] args){
    JFrame frame = new JFrame("Draw Ellipse Demo");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.getContentPane().add(new CC_SimplePerceptron());
    frame.pack();
    frame.setSize(new Dimension(maxD, maxD));


    System.out.println("Point initialiations");
    //initializing 100 random points
    for(int i = 0; i < points.length; i++){
        points[i] = new Point();                //random point
        System.out.println("Point " + i + " =" + points[i].getX() + ", " + points[i].getY());
    }

    float[] inputs = {-1f,0.5f};                //0.5f to indicate its float not double
    int guess = p.guess(inputs);

    System.out.println(guess);
    frame.setVisible(true);

}