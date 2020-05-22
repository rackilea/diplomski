import java.awt.Color;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ColorMap map = new ColorMap();
        System.out.println(map.get(19));

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
        int positiveIntKey = Math.abs((Integer) key);

        Color color = super.get(positiveIntKey);
        if(color == null){
            fillMapUpTo(positiveIntKey);
        }
        return super.get(positiveIntKey);
    }

    private void fillMapUpTo(Integer positiveIntKey) {

        for(int key = 0; key <= positiveIntKey; key++){
            if(super.get(key) == null){
                put(key,makeRandomColor());
            }
        }
    }

    private Color makeRandomColor(){
        return new Color( rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }
}