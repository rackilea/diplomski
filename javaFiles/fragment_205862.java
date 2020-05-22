abstract class Motor{
        int fuel;
        int getFuel(){
            return this.fuel;
        }
        abstract void run();
    }

   public class Player extends Motor {
       public void run(){
           print("wroooooom");//calling print method to print passed string
        }

    public void print(String string) {
        System.out.print(string);
    }

  public static void main(String []args){
    Player p1 = new Player();//creating a object of Player class to access its methods
    p1.run();//calling the run method
    }
}