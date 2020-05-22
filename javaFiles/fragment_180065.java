public class .... {

    private static final Pattern COMMA = Pattern.compile(",");

    public static void main(String[] args) {
        try {
            BufferedReader myReader =
                    new BufferedReader(new FileReader("MyFolder/myFile2.txt"));

            List<Integer> myList = new ArrayList<Integer>();
            int total = 0;
            String line;
            while ((line = myReader.readLine()) != null) {
                for (String token : COMMA.split(line)) {
                    try {
                        total += Integer.parseInt(token);
                    } catch (NumberFormatException ex) {
                        System.err.println(token + " is not a number");
                    }
                }
            } 

            System.out.print(total);

            myReader.close();
        } catch(FileNotFoundException e){

        } catch(IOException e){

        }
    }
}