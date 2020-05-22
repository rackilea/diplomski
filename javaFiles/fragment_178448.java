// Code from https://stackoverflow.com/questions/8496494/
Runtime rt = Runtime.getRuntime();
Process pr = rt.exec("java -jar test.jar args");

 // Check retVal to test
int retVal = pr.waitFor();