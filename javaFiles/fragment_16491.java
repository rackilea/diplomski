...............................
...............................

public class MQN {

    TopologyAnalyser ta = new TopologyAnalyser();
    HBDAPlugin hbda = new HBDAPlugin();

    public static void main(String [] args) {
        // This is where the execution of the program will begin

    }

    public String calculateMQN(Molecule m) {
        if (!m.dearomatize()) {
            System.out.println("DEAROMATIZE ERROR");
    .............
    ..............