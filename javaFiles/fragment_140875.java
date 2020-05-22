public class AmpImp {

    private List<Amp> resultProdInfo;

    public AmpImp() {
        // Do the business job here.
        resultProdInfo = loadItSomehow();
    }

    public List<Amp> getResultProdInfo() {
        // Do NOT do the business job here. Just return the property.
        return resultProdInfo;
    } 

    // ...
}