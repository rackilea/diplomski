public static void main(String args[]){
    try{
        String keyword = "engineering";
        Pattern keywordPattern = Pattern.compile(keyword);

        Pattern hashTagPattern = Pattern.compile("#[a-zA-Z0-9_]");

        FileInputStream fInstream = new FileInputStream("E:\\t.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fInstream));
        String strLine;


        int numberOfKeywords = 0;
        int numberOfWords = 0;
        int numberOfHashtags = 0;

        while((strLine = br.readLine()) != null){
            Matcher  matcher = keywordPattern.matcher(strLine.toLowerCase());
            while (matcher.find())
                numberOfKeywords++;
            numberOfWords += strLine.split("\\s").length;
            matcher = hashTagPattern.matcher(strLine);
            while (matcher.find())
                numberOfHashtags++;
        }

        System.out.println(numberOfWords);
        System.out.println(numberOfKeywords);
        System.out.println(numberOfHashtags);
        br.close();

    }catch (FileNotFoundException fe){
        fe.printStackTrace();
        System.out.println("Unable to locate file");
        System.exit(-1);
    }catch (IOException ie){
        ie.printStackTrace();
        System.out.println("Unable to read file");
        System.exit(-1);
    }
}