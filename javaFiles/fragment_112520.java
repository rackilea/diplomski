String[] difficultyOptions = new String[] {"Easy", "Medium", "Hard"};
int response = JOptionPane.showOptionDialog(null, "Message:  Choose Your Difficulty:", "Title:  Difficulty Selection",
    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
    null, options, options[0]);

switch(response) {
    case 0:
        //this is for easy
        break;
    case 1:
        //this is for medium
        break;
    case 2:
        //this is for hard
        break;
}