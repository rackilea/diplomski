package battlesimMK2;
public class Main {

    public static void main(String Arg[]) {
        String WeponEquiped = "BasicAxe";
        System.out.print(BasicAxe.Str());
        System.out.print(BasicAxe.Str());
    }
}

package battlesimMK2;
import java.util.Random;

public class BasicAxe {
    static Random rnd = new Random();
    static int Str() { return rnd.nextInt(4)+5; }
}