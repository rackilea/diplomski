class state extends JComponent {

   private boolean undoable;
   private JComponent toSave;

   public state (boolean undoable, JComponent toSave, ...) {
      this.undoable = undoable;
      this.toSave = toSave;
      ...
   }
...
}