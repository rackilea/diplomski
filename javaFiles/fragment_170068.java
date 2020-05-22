import java.awt.Color;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ColorMap map = new ColorMap();
        System.out.println(map.get(19));
        System.out.println(map.get(9));
        System.out.println(map.get(9));
        System.out.println(map.get(0));

        for(int key : map.keySet()){
            System.out.println(key);
        }
    }
}

class ColorMap extends HashMap<Integer, Color>{

    Random rand = new Random();

    @Override
    public Color get(Object key){

        if(! (key instanceof Integer)) return null;

        Color color = super.get(key);
        if(color == null){
            color = makeRandomColor();
            put((Integer) key,color);
        }
        return color;
    }

    private Color makeRandomColor(){
        return new Color( rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }
}