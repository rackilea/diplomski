public class LogReader {

    public void processWspLogFile() throws IOException {
        //a. I would reference to my file
        File wspLogFile = new File("data/wsp.log");
        //b. I would use the mechanism to read the file using BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(wspLogFile));

        String currLine = null;//This is the current line (like my cursor)

        //This will hold the data of the file in String format
        StringBuilder stringFormatter = new StringBuilder();
        boolean firstIterationDone = false;//The first line will always contains the format, so I will always append it, from the second I will start making the checkings...

        // Now I can use some regex (I'm not really good at this stuff, I just used a Web Page: http://txt2re.com/)
        /* This regex will match the lines that contains the date in this format "29. Jan. 12:22", when I take a look at your file
          I can see that the "additional text of the message" does not contains any date, so I can use that as my point of separation*/
        String regex = "(\\d)(\\d)(\\.)(\\s+)([a-z])([a-z])([a-z])(\\.)(\\s+)(\\d)(\\d)(:)(\\d)(\\d)";
        //As part of using regex, I would like to create a Pattern to make the lines on the list match this expression      
        Pattern wspLogDatePattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        //Use of the line separator of the O.S
        String lineSeparator = System.getProperty("line.separator");

        while ((currLine = bufferedReader.readLine()) != null) {

            if (!firstIterationDone) {
                stringFormatter.append(currLine);
                firstIterationDone = true;
            } else {
                Matcher wspLogDateMatcher = wspLogDatePattern.matcher(currLine);    

                //The first time we will check if the second line has the pattern, if it does, we append a line separator
                if (wspLogDateMatcher.find()) {
                    //It is a "normal" line
                    stringFormatter.append(lineSeparator).append(currLine);             
                } else {
                    //But if it doesn't, we append it on the same line
                    stringFormatter.append(" ").append(currLine.trim());
                }
            }
        }
        System.out.println(stringFormatter.toString());
    }
}