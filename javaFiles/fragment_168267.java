public static void main(String[] args) {
       Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
       int w = sSize.width;
       int h = sSize.height;
       int x = (int)((Math.random()* w) - w/3);
       int y = (int)((Math.random()* h) - 100);
       System.out.println(x + " " + y);
       JFrame f = new MyFrame(w / 3, 100, x, y); 
       f.setVisible(true);
 }