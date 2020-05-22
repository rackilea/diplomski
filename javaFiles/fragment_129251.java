public void actionPerformed(ActionEvent e){
    //Check if action was a jradiobutton
    if(e.getActionCommand().equals("select")){

        int count = 0;
        //Here check the amount of buttons selected
        for(JRadioButton button: buttons){
            if(button.isSelected()) count++;
        }

        //Now check if count is over 12
        if(count > 12){
            for(JRadioButton button: buttons){
                 //if the button trying to activate when 12 already have been, disable it
                 if(button.equals(e.getSource()) button.setSelcted(false);
            }
        }
    }
}