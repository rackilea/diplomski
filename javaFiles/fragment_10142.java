public class Wire implements Connection<Electricity> {
    private ArrayList<Inlet<Electricity>> outlets = new ArrayList<Inlet<Electricity>>();

    public void outputToAll() {     
        for (Inlet<Electricity> inlet : outlets){
            inlet.addToStore(new Electricity(amountPer));
        }
    }
    ...
}