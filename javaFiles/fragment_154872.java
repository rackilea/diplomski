BufferedReader br = new BufferedReader(...);
String line;
while (keepReading) {
    line = reader.readLine();
    if (line == null) {
        //wait until there is more of the file for us to read
        Thread.sleep(1000);
    }
    else {
        //do something interesting with the line
    }
}