JLabel counter = new JLabel("Hello World"); 
String ret;
if(counter.getText().equals("Hello World")){
    ret = counter.getText();
    counter.setText("0");
}