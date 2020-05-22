package weather;
import java.util.ArrayList;

public class Sky {
    private ArrayList<Cloud> clouds;

    public Sky(){
        clouds = new ArrayList<Cloud>();
    }

    public boolean add(Cloud c){
        clouds.add(c);
        return true;  //always return true
    }
}