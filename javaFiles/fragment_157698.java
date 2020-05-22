public static void main(String[] args) throws IOException {
    File file = new File("/path/to/InputFile");
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    String line = null;
    while( (line = br.readLine())!= null ){
        // \\s+ means any number of whitespaces between tokens
        String [] tokens = line.split("\\s+");
        String var_1 = tokens[0];
        String var_2 = tokens[1];
        String var_3 = tokens[2];
    }
}