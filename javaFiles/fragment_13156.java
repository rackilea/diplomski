public static void main(String[] args) {

    String line = "";
    int count = 0;
    try {
        BufferedReader br = new BufferedReader(new FileReader("comments.txt"));
        while ((line = br.readLine()) != null) {
            if (line.contains("//")) {
                count++;
            } else if (line.contains("/*")) {
                count++;
                while (!line.contains("*/") && !(line = br.readLine()).contains("*/"));
            }
        }
        br.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("count=" + count);
}