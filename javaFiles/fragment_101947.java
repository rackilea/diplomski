public class SequentialPrint {
    private List colors;
    private List prefix;

    public SequentialPrint(List colors){
        this.colors = colors;  // what if the array you pass in is null?
        // why not initialize prefix here?  it's null if you don't.
    }