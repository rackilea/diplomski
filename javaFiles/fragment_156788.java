public class MyRunnable implements Runnable {

  private String identifier = "";

  public MyRunnable(String identifier) {
    this.identifier = identifier;
  }

  @Override
  public void run() {
    MyData myData = MyDataManager.getInstance().getMyData(identifier)
    System.out.println(String.format("Data retrieved : %s", myData.toString()));
  }

}