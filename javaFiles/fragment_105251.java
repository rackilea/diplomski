List<PokemonBean> plist = new ArrayList<PokemonBean>();
PokemonBean p1 = new PokemonBean();
p1.setNumber(1);
p1.setName("Bulbasaur");
p1.setType("Grass");

PokemonBean p2 = new PokemonBean();
p2.setNumber(25);
p2.setName("Pikachu");
p2.setType("Electric");

plist.add(p1);
plist.add(p2);

Gson agson = new Gson();
Type myListType = new TypeToken<List<PokemonBean>>(){}.getType();
String myJsonString = agson.toJsonTree(plist, myListType);