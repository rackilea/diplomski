public static void main(String[] args) {
    String json = your json string;
    TestJson[] respone = new Gson().fromJson(json, TestJson[].class);
    for (TestJson s : respone) {
       System.out.println("File name: " + s.getFile_name());
    }
}