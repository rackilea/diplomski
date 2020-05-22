public void connect(CommPortIdentifier portId) throws Failure {
    if (portId == null)
        throw new Failure("No port set");

    try { port = (SerialPort) portId.open(getClass().getName(), 10000); } 
    catch (PortInUseException e) {
        throw new Failure("Port in use by " + e.currentOwner,e); }

    try {
        port.setSerialPortParams(9600, SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        port.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN
                              | SerialPort.FLOWCONTROL_RTSCTS_OUT);
    } catch (UnsupportedCommOperationException e) { throw new Failure(e); }

    port.setRTS(true);

    // More setup
}