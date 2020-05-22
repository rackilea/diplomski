List<Salad> salads = new ArrayList<>();

while(cursor.moveToNext()){
  String name = cursor.getString(0);
  int photo = cursor.getInt(1);
  boolean isFavorite = (cursor.getInt(2) == 1);

  Salad salad = new Salad(name,photo,isFavorite);
  salads.add(salad);
}