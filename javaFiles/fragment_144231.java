@Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        inpText = inputField.getText();
        String[] lines = inpText.split("\n");
        String[][] words = new String[lines.length][20];
        for(int i=0;i<lines.length;i++){
            words[i] = lines[i].split(" ");
        }
        translate("<html>");
        for(int i=0;i<lines.length;i++){
            for(int j = 0;j<words[i].length;j++){
                translate(words[i][j] );
            }
            translate("<br/>");
        }
        translate("</html>");
    }