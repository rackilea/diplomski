private List<JButton> buttons;
private double tempNum1;
private double tempNum2;
private boolean pointOn = false;
private int APC = 1; 
//make them private why public and static? 


public GUI(){
    ActionListener numListener = new GUINumListener();

    //initiliatze buttons  

    int size=10;
    buttons= new ArrayList<>(size);

    for(int i=0;i<size;i++){
         JButton button = new JButton();
         button.addActionListener(numListener);
         buttons.add(button);             
    } 

}


private class GUINumListener implements ActionListener{
 @Override
 public void actionPerformed(ActionEvent e){
        if (e.getSource() == buttons.get(0)){ // actionCommand returns string you have to use getSource() or setting an actionCommand to the button and compare num0.getActionCommand()
             tempNum2 *= 10;
        }else if (e.getSource() == buttons.get(1)){
            if (!pointOn){ // u were assigning pointOn = false
                tempNum2 = (tempNum2 * 10) + 1;
            }else{
                tempNum2 = (tempNum2 * Math.pow(10, APC) + 1) / Math.pow(10, APC);
                APC++;
            }
            ansField.setText(Double.toString(tempNum2));
        }

}