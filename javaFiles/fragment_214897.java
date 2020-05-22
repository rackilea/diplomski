public static void main(String[] args) {
    // write your code here
    String fileLocation = "C:\\1.diff";
    String fileLocation1 = "C:/1.diff";
    try {
        FileInputStream f = new FileInputStream(fileLocation);

        BufferedReader reader = new BufferedReader(new InputStreamReader(f));

        String line = reader.readLine();
        System.out.println("11111111111111111111111111");

        while (line != null) {
            // Process line
            line = reader.readLine();
            System.out.println(line);

        }
        System.out.println("11111111111111111111111111");


    } catch (Exception ex) {

        System.out.println(ex);
    }
    try {
        FileInputStream ff = new FileInputStream(fileLocation1);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(ff));
        String line1 = reader1.readLine();
        System.out.println("2222222222222222222222222");

        while (line1 != null) {
            // Process line
            line1 = reader1.readLine();
            System.out.println(line1);

        }
        System.out.println("2222222222222222222222222");

    } catch (Exception ex) {

        System.out.println(ex);
    }

}