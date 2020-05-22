//build listener class
 class RecommendListener implements ActionListener {
     public void actionPerformed(ActionEvent e) {
        //build in logic for choice made here
        String resultsTabChoice;
        resultsTabChoice = (String)resultsTabList.getSelectedValue();

        if( resultsTabChoice.equals("A")) {
            recommendOutput = "One";}
        else {recommendOutput = "Two";}
        System.out.println(recommendOutput); // <-###################
    }
}