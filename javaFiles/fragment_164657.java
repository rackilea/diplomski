public void loadUserData(ArrayList<User> arraylist) {
    StringBuilder sb = new StringBuilder();
    try {
        List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
        for(String line : lines) {
           // String[] userParams = line.split(";");

            //String name = userParams[0];
            //String number= userParams[1];
            //String mail = userParams[2];
            sb.append(line);
        }   
        String jdbcString = sb.toString();
        System.out.println("JDBC statements read from file: " + jdbcString );
    } catch (IOException e) {
        e.printStackTrace();
    }
}