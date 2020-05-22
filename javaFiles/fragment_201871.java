String path = "/nouns.txt";
try {
    InputStream is = this.getClass().getResourceAsStream("/misc/sample.txt");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));


    String line = bufferedReader.readLine();
    for(; line!=null; line=bufferedReader.readLine()) {
        System.out.println(line);
    }


    bufferedReader.close();
} catch (IOException e) {
    e.printStackTrace();
}