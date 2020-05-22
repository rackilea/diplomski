public class yolo {
    public static void frodo() throws Exception {

        String[] keywords = { "Professor" , "engineering" , "data" , "mining" , "research"};
        for(int i=0; i< keywords.length; i++){

        String testWord = keywords[i];
        File document = new File("path//to//doc1.txt");
        boolean check = true;

        try {
            FileInputStream fstream = new FileInputStream(document);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            strLine = br.readLine();

            // Read File Line By Line

            int count = 0;
            while ((strLine = br.readLine()) != null) {

                // check to see whether testWord occurs at least once in the
                // line of text
                check = strLine.toLowerCase().contains(testWord.toLowerCase());

                if (check) {
                    // get the line
                    String[] lineWords = strLine.split("\\s+");
                    count++;
                }

            }
            System.out.println(testWord + "frequency: " + count);

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}