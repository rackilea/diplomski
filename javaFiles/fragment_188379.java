public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            String btnText = ((Button)e.getSource()).getLabel();
            int counter = 0;
            for(int i=0; i<buttonArr.length; i++) {
                if (buttonArr[i].getLabel().equals(btnText)) counter++;
                if (count > 1) {
                   for(int j=0; j<buttonArr.length; j++) {
                      if (buttonArr[j].getLabel().equals(btnText))
                         this.remove(buttonArr[j]);
                   }
                }
            }
            pack();
        }
}