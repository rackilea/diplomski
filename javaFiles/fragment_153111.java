for (int i = 0; i < gameButtons.length; i++) {
    for (int j = 0; j < gameButtons[i].length; j++) {
        // cast it to an array type before accessing
        JButton[][] subArray = (JButton[][])(gameButtons[i][j]);

        for (int k = 0; k < 3; k++)
            for (int l = 0; l < 3; l++)
                subArray[k][l] = new JButton();
    }
}