public class F1 ... {
    private final Data myData;

    public F1(Data theData) {
        myData = theData;
    }

    ....
}

public class Main {
    Data myData;

    public static void main(String args[]) {
        Main m = new Main();
        m.setMyData(new Data());

        F1 f = new F1(m.getMyData());
        ...
     }
}