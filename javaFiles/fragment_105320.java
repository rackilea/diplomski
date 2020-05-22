public class OutputElement {
    List<OutputElement> outData = new ArrayList<>();                 

    @Override
    public void addOutData(OutputElement outputElement) {        
        this.outData.add(outputElement);
    }
}