public class Cliente{

    private int clientID;
    private String clientName;
    private double clientDebt;
    private ArrayList<double[]> clientHistory = new ArrayList<double[]>();


    public void registerID(int newID) {
        this.clientID = newID;
    }

    // Here is the issue
    public void newInvoice(double[] invoice) {
        clientHistory.add(invoice);
    }

}