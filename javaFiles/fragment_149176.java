public Class1{

 static int players;

 public static void selectPlayers() {

   JButton player1 = new JButton("1 Player");
   player1.addMouseListener(new MouseAdapter() {
     public void mousePressed(MouseEvent arg0) {
        Class1.players = 1;
    }
 });
 }
}