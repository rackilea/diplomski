public class Avalon {

    private int[] ia = new int[100];

    public void init(){
      for (int i = 0; i < 100; i++){
         ia[i] = i;
      }
    }

    public int[] getArray(){
      return ia;
    }

public static void main(String[] args) {

    System.out.println("Hello World");
    Avalon obj = new Avalon();
    obj.init();
    //get array
    int[] array = obj.getArray();

    }
}