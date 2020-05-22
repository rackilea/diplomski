List<String[]> token = new ArrayList<String[]>();
while ((linea = rEntrada.readLine()) != null){
    tokens.add(linea.split(delimitador));
}

for (String [] token: tokens) {
  System.out.println(token[0] + ":" token[1]);
}