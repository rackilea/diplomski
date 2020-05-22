import java.util.ArrayList;
public class Two {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(One.temp);
        ArrayList<Integer> copy=One.temp;
        One.temp.add(100);
        System.out.println(copy);
    }

}
class One{
    public static ArrayList<Integer> temp = new ArrayList<Integer>();

    public static ArrayList<Integer> getTemp() {

        return temp;
    }

    static {
            // TODO Auto-generated method stub

            for (int i = 0; i < 10; i++) {

                temp.add(i * 10);
            }

        } 
}