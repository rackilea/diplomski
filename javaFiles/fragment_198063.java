public void probeClicked(){

for (int i = 0; i < buttons.length; i++) {
    for (int j = 0; j < buttons[0].length; j++) {

        if (counts[i][j]==MINE){
            buttons[i][j].setText("M");
            buttons[i][j].setEnabled(false);
            JOptionPane.showMessageDialog(frame, "Probe clicked! 1 Mine has been revealed.");
            return;


        }
        else{

            continue;
        }
} }