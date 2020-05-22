public interface PopularityService {
  public List<Item> getTopItems(int count);//gets n top items

  //lets the service know someone liked a thing
  public void registerLike(Item item, Person liker);

  //lets the service know someone viewed a 
  public void registerView(Item item, Person viewer);thing
}