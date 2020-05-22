class Thing{
  public int id;
  public Thing( int id ){ this.id = id;}
  public String toString() { return ""+id; }
}

List<Integer> ids = new ArrayList<Integer>();
List<Thing> things = new ArrayList<Thing>();

ids.add(1);
ids.add(2);
ids.add(3);
ids.add(4);

things.add( new Thing( 2 ) );
things.add( new Thing( 3 ) );

List<Thing> intersection = ids.stream().flatMap( id -> things.stream().filter(
 thing -> id == thing.id
).map(
 thing -> thing
)).collect(Collectors.toList());