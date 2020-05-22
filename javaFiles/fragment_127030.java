while (e.hasMoreElements()) {
    CommPortIdentifier id = (CommPortIdentifier) e.nextElement();
    if(serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
        System.out.println(serialPortId.getName());//print the serial port name
    }
}