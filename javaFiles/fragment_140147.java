public void drawString(MouseEvent e) throws IOException {
    if(textClick) { // none of this == true stuff please
        int xLoc = e.getX();
        int yLoc = e.getY();
        String prompt = "Enter your Account Number:";
        String input = JOptionPane.showInputDialog(someComponent, prompt);

        // !!! no 
        // g2.drawString(accStr, xLoc, yLoc); // no don't do this

        myJLabel.setText(input); 

        textClick=false;
    }
}