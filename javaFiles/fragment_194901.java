public class FileLinkList{

    public static void main(String[] args) {

        BufferedReader br = null;
            LinkedList<String> list = new LinkedList<String>();
            String word;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("LEXICON.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                            word = sCurrentLine.trim().split(" ")[0];
                            list.add(word.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}