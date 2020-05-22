Object[] options = {"CD",
        "MP",
        "EU"};
    int n = JOptionPane.showOptionDialog(null,
                    "Enter the FROM Currency Code",
                    "From Currency",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);