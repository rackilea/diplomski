int y = Integer.parseInt(jTextField1.getText());
for (x = 0,z=0; x <= (y+y-1); x++) {
   if(x<=y){
     z++;
   }else{
    z--;
   }
   for(int i=0;i<=z;i++){
     jTextField2.setText(jTextField2.getText() + "*");
   }
   jTextArea1.append(jTextField2.getText() + "\n");
}