String output = "";
for(int i = 0; i<games.size(); i++){
    String everything = sku.get(i).toString();
    String everything2 = games.get(i).toString();

    output += everything +" "+ everything2 + "\n";       
}
JOptionPane.showMessageDialog(null, output);