public class Map {

  private ArrayList <ArrayList<Places>> newMap = new ArrayList<>();

  public Map(int width, int height, Collection <Coordinate> places){

    for (int i=0;i<=width-1;i++){
      ArrayList<Places> list = new ArrayList<Places>();
      for (int j=0;j<=height-1;j++){
        list.add(new Place(new Coordinate(i,j)));
      }
      newMap.add(list);
    }