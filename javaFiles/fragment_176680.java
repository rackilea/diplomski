public class MyTextHandler implements ContentHandler {
  ....
  private ArrayList<YourModel> list;

  public MyTextHandler() {
    list= new ArrayList<YourModel>();
  }
  public ArrayList<YourModel> getList() {
    return list;
  }
  ....
}