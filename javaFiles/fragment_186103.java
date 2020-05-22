int result = JOptionPane.showConfirmDialog(null, "Can I ask you a question", "Quesion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
switch (result) {
    case JOptionPane.YES_OPTION:
        //...
        break;
    case JOptionPane.NO_OPTION:
        //...
        break;
}