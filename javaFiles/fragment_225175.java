@ManagedBean
@ViewScoped
public class IndexBean implements Serializable {

    private ArrayList allGarbage;

    public IndexBean() {
        allGarbage = new ArrayList();
        allGarbage.add(new Garbage("Abc", "Abc", "28/03/2011 12:13:32"));
        allGarbage.add(new Garbage("Bbc;", "bbc", "28/03/2011 12:14:32"));
        allGarbage.add(new Garbage("Cbc", "Cbc", "28/03/2011 12:17:32"));
        allGarbage.add(new Garbage("1Abc", "1Abc", "28/03/2011 12:13:32"));
        allGarbage.add(new Garbage("2Bbc;", "2bbc", "28/03/2011 12:14:32"));
        allGarbage.add(new Garbage("3Cbc", "3Cbc", "28/03/2011 12:17:32"));
        allGarbage.add(new Garbage("4Abc", "4Abc", "28/03/2011 12:13:32"));
        allGarbage.add(new Garbage("5Bbc;", "5bbc", "28/03/2011 12:14:32"));
        allGarbage.add(new Garbage("6Cbc", "6Cbc", "28/03/2011 12:17:32"));
    }

    public ArrayList getAllGarbage() {
        return allGarbage;
    }

}