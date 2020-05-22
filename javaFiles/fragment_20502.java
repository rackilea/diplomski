serviceConfigList.stream()
        .filter(ser -> ser.getValid().equals("true"))
        .forEach(ser -> {
            Connection.SERVICE_PORT = ser.getPort();
            Connection.SERVICE_ADDRESS = ser.getIp();
            // other code..
    });