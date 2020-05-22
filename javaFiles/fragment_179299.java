public static void main(String[] args) {
    List<String> li=new TestClass().textFiles("your Directory");
    for(String s:li){
        try(BufferedReader br = new BufferedReader(new FileReader(s))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}