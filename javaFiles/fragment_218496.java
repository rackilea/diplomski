public class Main {

  public static void main(String[] args) {
    try {
      List<String> menu = Executors.newFixedThreadPool(1).submit(new ReadFromFile(new File("src/test.csv"))).get();
      menu.forEach(System.out::println);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}