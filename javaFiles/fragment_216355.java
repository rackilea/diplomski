import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class LiqPlantSim{   

    private List<Silo> silos;
    public Pipe pipe;

    public LiqPlantSim(){
        silos = new ArrayList<>();
        silos.add(new Silo(false,false));
        silos.add(new Silo(false,true));
        silos.add(new Silo(true,false));
        silos.add(new Silo(true,true));
        pipe = new Pipe();          
    }

    public Silo getSilo(int index) {
        return silos.get(index);
    }

    //Possibly other methods to access silos
}