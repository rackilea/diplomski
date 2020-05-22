int result = JOptionPane.showOptionDialog(frame,
            "Please pick an option",
                    "Chess",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);

switch (result) {
    case 0:
        // Rematch
        break;
    case 1:
        // Exit
        break;
    case 2:
        // Reset players...
        break;
}