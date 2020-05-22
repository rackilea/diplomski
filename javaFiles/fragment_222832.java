public void start() throws CreateDocumentConfigurationException {
    // Custom button text
    Object[] options = {"Yes, please", "Use default instead"};

    int n = JOptionPane.showOptionDialog(null,
            "Would you like to enter DB credentials?",
            "DB Question", JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

    estimateUserInput(n); // process result here. 0 - for entering new one, 1 - for using default
}