public static void main(String[] args){
    GUI t = new GUI();  
    JFrame jf = new JFrame();
    jf.add(t);

    jf.setTitle("Animation");
    jf.setSize(600,400);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setVisible(true);
}