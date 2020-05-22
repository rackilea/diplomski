class Rpm{
    double value=0.0;
    final double LIMIT = 2000.0;
    public void setValue(double value){
        if(value < LIMIT)
            this.value= value;

    }
    public double getValue(){
        return this.value;
    }
}

public class  yourclassname {
public static void main(String[] args) {
    double startRadius = 6; //Radius of stock diameter
    double faceFinish = 0; 
    double feed = .010; //Amount the tool will advance per revolution
    double sfm = 200; //Surface speed of tool (Surface feet per minute)
    Rpm rpm = new Rpm();
    double totalTime = 0;

    while(faceFinish < startRadius) {
        startRadius -= feed; //reduces diameter by feed
        rpm.setValue( (sfm * 3.82) / (startRadius * 2)); //establishes new rpm per tool advance            
        totalTime += (feed / (feed * rpm.getValue())) * 60;
    }
    int hours = (int) (totalTime / 3600);
    int minutes = (int) ((totalTime % 3600) / 60);
    int seconds = (int) (totalTime % 60);
    System.out.printf("%02d:%02d:%02d\n", hours, minutes, seconds);
}
}