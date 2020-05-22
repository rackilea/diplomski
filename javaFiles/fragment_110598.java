JOptionPane pane = new JOptionPane(
        "Are you sure that you want to exit?",
        JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION) {
     @Override
        public void setValue(Object newValue) {
         if (newValue == Integer.valueOf(JOptionPane.YES_OPTION)) {
             System.out.println("yes");
         } else if ( newValue == Integer.valueOf(JOptionPane.NO_OPTION)) {
             System.out.println("no");

         }
     }
};