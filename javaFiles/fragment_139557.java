public class FooClass {
   private Player player1;
   private GameBoard game;
   private JTextField playersName;
   private JLabel lblNewLabel1 = new JLabel();

   public FooClass() {
      JButton button = new JButton("Start");
      button.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            game = new GameBoard(); // field
            game.main(null);
            String newPlayerName = playersName.getText();
            player1 = new Player(newPlayerName); // field
            lblNewLabel1.setText(newPlayerName); // set label
         }
      });
   }
}