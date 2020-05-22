BufferedReader reader = new BufferedReader(new FileReader(filename));
while(String line = reader.readLine()) {
    if (line.indexOf("in") >= 0) {
        String[] fields = line.split(":");
        System.out.println(fields[2]);
    }
}