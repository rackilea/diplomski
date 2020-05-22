public static void main(String[ ] args){
   chromeNPlayerScreen screen = new chromeNPlayerScreen();
   screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   screen.add(dPnl);
   screen.setSize(600,600);;
   screen.setVisible(true);
   screen.setResizable(false);
   screen.setLocation(200, 200);
}