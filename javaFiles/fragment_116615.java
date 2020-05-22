class MotorVehicle{
  int motor_a;
  String motor_b;
  Silnik motor_c;
  public MotorVehicle(int i, String string, Silnik silnik) {
    // TODO Auto-generated constructor stub
    motor_a = i;
    motor_b = string;
    motor_c = silnik;
  }

}
class Silnik{
  int silinik_a;
  long silinik_b;
  public Silnik(int i, long l) {
    // TODO Auto-generated constructor stub
    silinik_a = i;
    silinik_b = l;
  }
}

public class Test extends Driver {
  public static void main(String[] args) {
    String[] name = { "Audi 100", "Audi 200", "Audi 4000", "Audi 50", "Audi e-tron", "Audi A2", "Audi A3", "Audi A4",
        "Audi A5", "Audi A6", "Audi F103", "Audi 5000", "Audi 80", "Audi 90", "Audi A1", "Audi A7", "Audi A8",
        "Audi Allroad", "Audi Cabriolet", "Audi Coupe", "Audi Coupe S" };

    int[] engine = { 10 * 20 };
    int[] numberOfSeats = { 1, 2, 3, 4, 5 };
    Random r = new Random();
    MotorVehicle[] model = new MotorVehicle[100];


    for (int i = 0; i < model.length; i++) {
      int rand5 = (int)(Math.random()*5) + 1;
      int randN = r.nextInt(name.length);
      String randName = name[randN];
      int rand250 = (int)(Math.random()*250)+50;
      long rand6000 = (long)(Math.random()*6000l)+501;
      model[i] = new MotorVehicle(rand5, randName,new Silnik(rand250, rand6000));
    }

    for(int i = 0;i<model.length;i++) {
      System.out.println(model[i].motor_a + " #  "+model[i].motor_b + " # "+model[i].motor_c.silinik_a + " # "+ model[i].motor_c.silinik_b );
    }
  }