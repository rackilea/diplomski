File file = new File(fileName);
InputStream is = new FileInputStream(file);
BufferedReader reader = new BufferedReader(new InputStreamReader(is, encoding));

try {
    String line = reader.readLine();
    while (line != null) {
        //replace qoutes
        line = line.replace("\"", "");
        line = line.replace("'", "");
        //split line according to given delimiter
        String[] items = line.split(delimiter);
        //handle items...
        line = reader.readLine();
    }
}
catch (IOException e) {
    //handle exception...
}