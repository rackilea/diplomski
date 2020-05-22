String simulatedUserInput = "input1" + System.getProperty("line.separator")
    + "input2" + System.getProperty("line.separator");

InputStream savedStandardInputStream = System.in;
System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

// code that needs multiple user inputs

System.setIn(savedStandardInputStream);