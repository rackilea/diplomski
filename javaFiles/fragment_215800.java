/**
 * This class contains methods for is for picking
 * out needed data from the source of a website.
 */
public class Scraper { 

    /**
     * This method scrapes the input URL.
     * @return A string containing the data from the webpage.
     * @throws IOException if there was a problem with accessing the website.
     */
    public static String scrapeWebsite(String url) throws IOException {

        String inputLine;
        StringBuilder sourcetext = new StringBuilder();

        URL urlconnect = new URL(url);
        URLConnection connection = urlconnect.openConnection();

        try(BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "UTF-8"))){

            while ((inputLine = in.readLine()) != null)
                sourcetext.append(inputLine);
        }
        return sourceText.toString().replace('"','*');
    }

    /**
     * This method parses through the data and adds the necesary information to
     * a specified .CSV file.
     * @param source The datasource, for example that returned by
     *               {@link scrapeWebsite()}.
     * @param targetFile The file path for the destination .csv file.
     * @throws IOException if there was a problem with accessing the file.
     */
    public static void getPlaintiff(CharSequence source, String targetFile)
            throws IOException{

        try(PrintWriter docketFile = new PrintWriter("tester.csv", "UTF-8")){

            for(int i = 0; i < 14; i++) {
                Matcher plaintiffMatcher = Pattern.compile(
                        "(?<=PlaintiffAtty_" + i + "\\*>).*?(?=</span>)")
                        .matcher(source);

                while (plaintiffMatcher.find())
                    docketFile.println(plaintiffMatcher.group());

                Matcher appraisedMatcher = Pattern.compile(
                        "(?<=Appraised_" + i + "\\*>).*?(?=</span>)")
                        .matcher(source);

                while (appraisedMatcher.find())
                    docketFile.println(appraisedMatcher.group());
            }
        }
    }
}