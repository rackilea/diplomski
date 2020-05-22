frame.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
         int Answer = JOptionPane.showConfirmDialog(frame, "You want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (answer == JOptionPane.YES_OPTION)
             exit(frame);
    }
}