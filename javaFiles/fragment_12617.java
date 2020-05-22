int supermarketsPerLine = 4;//The ammount of supermarkets displayed per line

StringBuilder text = new StringBuilder();
for (int i=0; i<supermarkets.length;i++){
    text.append(supermarkets[i].get-name()+", ");
    if(i%supermarketsPerLine == 0 && i>0) text.append("\n");
}
text.delete(text.length()-2, text.length()-1);// to remove the last comma (,) from the end of the list.     
JOptionPane.showMessageDialog(null,"Available supermarkets:\n"+text.toString());