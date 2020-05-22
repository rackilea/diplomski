public static void main(String args[]) {
        try {
            DOMParser parser = new DOMParser();
            String UrlToParse = "puttheurl.com";
            parser.parse(UrlToParse);
            Document doc = parser.getDocument();

            // Get the document's root XML node
            NodeList ProgramGuideRoot = doc.getChildNodes();

            // Navigate down the hierarchy to get to the program node
                // Starting with Program Guide Root -> Program Guide -> All Programs -> Individual Program
            Node PGR = getNode("ProgramGuideWCSResponse", ProgramGuideRoot);
            Node PG = getNode("programGuide", PGR.getChildNodes() );
            Node Programs = getNode("programs", PG.getChildNodes() );
            Node IndivdualProgram = getNode("program", Programs.getChildNodes() );

            // Load the executive's data from the XML
            NodeList nodes = IndivdualProgram.getChildNodes();
            String showTitleAttr = getNodeValue("programTitle", nodes);

            System.out.println("Program title is: " + showTitleAttr);
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
 }