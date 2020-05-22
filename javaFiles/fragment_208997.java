try {
    JSONParser parser = new JSONParser();
    Object obj = parser.parse(new FileReader("C:\\Users\\Home\\Documents\\read1.json"));

    JSONObject jsonObject = (JSONObject) obj;
    System.out.println(jsonObject);
} catch (FileNotFoundException e) {
    // handle file not found
} catch (IOException e) {
    // handle ioexception
}