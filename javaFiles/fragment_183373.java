private TwoWaySerialComm twoWaySerCom;

public AlarmGenerator() {

    initComponents();   

    twoWaySerCom = new TwoWaySerialComm();

    try {

        twoWaySerCom.connect("COM1");
    } 
    catch (Exception e) {

        e.printStackTrace();
    }
}