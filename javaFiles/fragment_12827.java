class MyAction extends AbstractAction {
       public MyAction(String text, ImageIcon icon,
                  String desc, Integer mnemonic) {
       super(text, icon);
       putValue(SHORT_DESCRIPTION, desc);
        putValue(MNEMONIC_KEY, mnemonic);
   }
   public void actionPerformed(ActionEvent e) {
        //do the action of the button here
    }
  }