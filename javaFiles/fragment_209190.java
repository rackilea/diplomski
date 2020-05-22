StringBuilder resultado = new StringBuilder();
for ( i=0;i<cart.size();i++) {
    String codebar = cart.get(i).getCodebar();
    String quantity = cart.get(i).getQuantity();
    //THIS LINE BELOW IS THE ONE I NEED TO HAVE IN TXT FILE
    String nuevo =format+", "+convertCodeToMonth(month)+", "+request.getPhone()+", "+"01"+", "+"2"+", "+"3"+", "+codebar+","+quantity;
    //append the new data, and a line break :
    resultado.append(nuevo);
    resultado.append("\n");
    Log.d("INFOOOOOOOOOOO", "onClick: "+nuevo);
}
writeToFile(resultado.toString());