public class test extends JDialog {
    ...    
    private int N;

    public int setVisible() {
        this.setVisible(true);
        return N;
    }

    public test() {
        super(null, ModalityType.APPLICATION_MODAL); 
        // <== pass parent window here if you have one, you don't seem to.. 
        ...
    }