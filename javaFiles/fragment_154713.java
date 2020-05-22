public class StreetHandling {

    List<Integer> number;
    List<String> firstWord;
    List<String> rest;

    public StreetHandling() {
        number = new ArrayList();
        firstWord = new ArrayList();
        rest = new ArrayList();
    }

    public static void main(String[] args) {

         StreetHandling sh = new StreetHandling();
         System.out.println("Read file : "+sh.finishReadFile("streets.txt"));

         //you can use the lists anyway you want from here

    }

    public boolean finishReadFile(String fname) {
         boolean finishRead = false;
         try {
              FileReader file = new FileReader(fname);
              BufferedReader br = new BufferedReader(file);
              String s = "";
              String arr[] = null;
              while (br.ready()) {
                 s = br.readLine().trim();
                 arr = s.split(" ");
                 number.add(Integer.parseInt(arr[0]));
                 firstWord.add(arr[1]);
                 rest.add(s.substring(arr[0].length() + arr[1].length() + 1));
             }
             finishRead = true;
         } catch (Exception e) {
             System.out.println(e);
         }

         return finishRead;

   }
}