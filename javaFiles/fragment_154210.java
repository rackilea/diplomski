// clear screen and then add new list
String text = numberTxtFld.getText();
boolean isNumber = false;
try{
    Integer.parseInt(text);
    numbersList.add(text);
    isNumber = true;
} catch(NumberFormatException ex){
    //JOptionPane.show.......
    numberTxtFld.setText("");
}
if(isNumber){
defaultListModel.clear();
for (Object x : numbersList) 
//.........