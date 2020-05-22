import java.util.ArrayList;
public class Bachelorstudenter {

    private ArrayList<Bachelorstudent> bs;

    public Bachelorstudenter() {    
        bs = new ArrayList<>();
    }

    public double bsGjennomsnitt() {    
        double sum = 0.0;
        double gjennomsnitt = 6.0;

        if(!bs.isEmpty()){
            for(Bachelorstudent b : bs){
                sum += b.finnGjennomsnitt();
            }
            gjennomsnitt = sum/bs.size()
        } 
        return gjennomsnitt;
    } 
}