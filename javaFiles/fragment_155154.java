String ipAddress= "192.168.1.12";

String[] elements = ipAddress.split("\\.");
elements[elements.length - 1] = 
    String.valueOf(Integer.parseInt(elements[elements.length - 1]) + 1);

String newAddress = String.join(".", elements);