public static void main(String[] args) throws FileNotFoundException, IOException {
    JSONParser parser = new JSONParser();
    Object obj = parser.parse(new FileReader("C:\\Users\\Home\\Documents\\read1.json"));

    JSONObject jsonObject = (JSONObject) obj;
    System.out.println(jsonObject);

}