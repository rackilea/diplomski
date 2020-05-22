String[] bg = new String[amount];

for(int i = 0; i < amount; i++){
  bg[i] = makeBaggage(country, flight, i);
  baggage.add(bg[i]);
  System.out.println(bg[i])
  ..