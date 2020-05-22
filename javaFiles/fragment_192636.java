T1.setText("40");
T2.setText("20"); 
this.add(B1);
B1.addActionListener(this);

public void actionPerformed(ActionEvent ev){

ST1=T1.getText(); 
ST2=T2.getText(); 
a=Double.parseDouble(ST1)-Double.parseDouble(ST2); 
ST3=""+a; 
}