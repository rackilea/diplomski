class Board2 extends JPanel {
   private static final int PREF_W = 200;
   private static final int PREF_H = 400;
   public static final String DIRECTION = "direction";
   private Direction direction = null;

   public Board2() {
      setBorder(BorderFactory.createTitledBorder("Board2"));
      InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
      ActionMap actionMap = getActionMap();

      for (Direction dir : Direction.values()) {
         inputMap.put(dir.getKeyStroke(), dir.getText());
         actionMap.put(dir.getText(), new MyArrowBinding(dir));
      }
   }

   private class MyArrowBinding extends AbstractAction {
      private Direction dir;

      public MyArrowBinding(Direction dir) {
         super(dir.getText());
         this.dir = dir;
         putValue(ACTION_COMMAND_KEY, dir);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         setDirection(dir);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public void setDirection(Direction direction) {
      Direction oldValue = this.direction;
      Direction newValue = direction;
      this.direction = newValue;

      firePropertyChange(DIRECTION, oldValue, newValue);
   }

   public Direction getDirection() {
      return direction;
   }
}