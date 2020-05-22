StringBuilder text = new StringBuilder();
for (int i=0; i<supermarkets.length;i++){
    text.append("\n"+supermarkets[i].get-name());
}

JOptionPane.showMessageDialog(null,"Available supermarkets:"+text.toString());