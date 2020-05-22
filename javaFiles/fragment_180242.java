protected void playAgain(String msg) {

    int result = JOptionPane.showConfirmDialog(this, 
            "<html>" + msg + "<br>Do you want to play again?", 
            "Play Agaion", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);

    switch (result) {
        case JOptionPane.YES_OPTION:
            setModel(new DefaultHangManModel("Your new secret word"));
            break;
        default:
            SwingUtilities.getWindowAncestor(this).dispose();
            break;
    }

}