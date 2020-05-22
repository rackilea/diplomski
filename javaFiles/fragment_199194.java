/**
     * PARSER METHOD
     */
    public static void PageScanner() throws IOException {
        System.out.println("Pick a website to scan.");

        // This do-while loop allows the user to try again after a mistake
        do {
            try {
                System.out.println("Enter a URL, starting with http://");
                url = urlInput.nextLine();
                // This creates a document out of the HTML on the web page
                Document doc = Jsoup.connect(url).get();
                // This converts the document into a string to be cleaned
                String htmlToClean = doc.toString();
                cleanString = Jsoup.clean(htmlToClean, Whitelist.none());
                correct = false;
            } catch (Exception e) {
                System.out.println("Incorrect format for a URL. Please try again.");
            }
        } while (correct);
    }