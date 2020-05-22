for(int i = 0; i < amount; i++){
  String[] bg = new String[amount];
  bg[i] = makeBaggage(country, flight, amount);
  baggage.add(bg[i]);
  System.out.println(bg[i]);
  ...