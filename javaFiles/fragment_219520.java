@Override
   public void ActionPerformed(ActionEvent e){
        JButton btn = (JButton)e.getSource();
        if(btn == btnName){
           String state = WritingZone.getText();
            WritingZone.setText(state+btnNum(operation));
        } else if(btn==otherButton)...
   }