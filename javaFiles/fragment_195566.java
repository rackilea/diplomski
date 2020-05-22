public class SecondClass {
    private TextArea tArea;
    SecondClass(TextArea ta) {
        tArea = ta;
    }
    void printOnTextArea() {
        System.out.println("*** printOnTextArea() ***");
        tArea.append("call from Second Class in printOnTextArea()");
    }
}