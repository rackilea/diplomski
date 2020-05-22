Object[] options = {"Yes","No","Cancel"};
int n = JOptionPane.showOptionDialog(frame,
        "Continue?",
        "Would you like to continue?",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[2]);
if (n == JOptionPane.YES_OPTION) {
    System.out.println("Clicked Yes");
} else if (n == JOptionPane.NO_OPTION) {
    System.out.println("Clicked No");
} else if (n == JOptionPane.CANCEL_OPTION) {
    System.out.println("Clicked Cancel");
} else {
    System.out.println("something else (like clicked the 'x' button)");
}