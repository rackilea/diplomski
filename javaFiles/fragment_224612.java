public class Test3 {
 public static void main(String[] args) throws Exception {
     String s2="text_t.txt";
     File _newf = new File("text_d.txt");
     changeOrder(_newf);
 }

 public static void changeOrder(File f) throws Exception {
     FileInputStream _inp = new FileInputStream(f.getAbsolutePath());
     BufferedReader _rd = new BufferedReader(new InputStreamReader(_inp));

     ArrayList<String[]> newFileContent = new ArrayList<String[]>();
     String _p=_rd.readLine();
     while (_p != null) {
         String [] _b = _p.split(" ");
         String temp = _b[_b.length - 2];
         _b[_b.length - 2] = _b[_b.length - 1];
         _b[_b.length - 1] = temp;
         newFileContent.add(_b);

          _p=_rd.readLine();
     }

     PrintWriter writer = new PrintWriter(f.getAbsolutePath(), "UTF-8");
     for (String[] line : newFileContent) {
         for (String word : line) {
             writer.print(word);
         }
         writer.println();
    }
    writer.close();
}