public class Shortener {

    private FileReader in;
    //the map
    private HashMap<String, String> abbreviations;

    /*
     * Default constructor that will load a default abbreviations text file.
     */
    public Shortener() {
        //initialize the map
        this.abbreviations = new HashMap<>();
        try {
            in = new FileReader("abbreviations.txt" );
            BufferedReader abrv = new BufferedReader(in) ;
            String line;
            while ((line = abrv.readLine()) != null) {
                String [] abv = line.split(",");
                //If there is not two items in the file, the file is malformed
                if (abv.length != 2) {
                    throw new IllegalArgumentException("Malformed abbreviation file");
                }
                //populate the map with the word as key and abbreviation as value
                abbreviations.put(abv[0], abv[1]);
            }
        }       

        catch ( Exception e ) {
            System.out.println( e );
        }
    }

    public String shortenWord( String inWord ) {
        String punc = new String(",?.!;") ;
        char finalchar = inWord.charAt(inWord.length()-1) ;

        // ends in punctuation
        if (punc.indexOf(finalchar) != -1) {
            String sub = inWord.substring(0, inWord.length() - 1);

            //Reference map
            String abv = abbreviations.get(sub);
            if (abv == null)
                return inWord;
            return new StringBuilder(abv).append(finalchar).toString();
        }

        // no punctuation
        else {
            //Reference map
            String abv = abbreviations.get(inWord);
            if (abv == null)
                return inWord;
            return abv;
        }
    }

    public void shortenMessage( String inMessage ) {
         String[] messageArray = inMessage.split("\\s+") ;
         for (String word : messageArray) {
            System.out.println(shortenWord(word));
        }
    }

    public static void main (String [] args) {
        Shortener s = new Shortener();
        s.shortenMessage("hello? any anyone thanks!");
    }
}