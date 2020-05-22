javax.comm.SerialPort port = ...{initialize your serial port}
BufferedReader portReader = 
    new BufferedReader(new InputStreamReader(port.getInputStream()));

try {
    String line = portReader.readLine();
} catch(IOException e) { ... }