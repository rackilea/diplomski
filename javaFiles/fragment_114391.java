public void actionPerformed(ActionEvent e){
    player.reset();
    System.out.println("reset button");

    label3.setText(""); // assuming no new messages..
    label.setText("Current Money:"+player.getCurrMon());
    text.setEnabled(true);

    invalidate();
    repaint();

}