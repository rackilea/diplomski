import java.util.ArrayList;
import java.util.List;

enum Color{
    Red,
    Green,
    Blue
}

public class Main {
    public static void main(String[] args) {
        List<Color> list=new ArrayList<Color>();
        list.add(Color.Red);
        list.add(Color.Green);
        System.out.println(list);
        extendSequence(list, Color.Blue, 2);
        System.out.println(list);
    }
    public static void extendSequence(List<Color> list, Color color, int times){
        if(list!=null) {
            for(int i=1;i<=times;i++)
                list.add(color);
        }
    }
}