public static void main(String[] args) throws Exception {

    //Your web site
    String website = "http://stackoverflow.com";
    //We will read the URL https://stackoverflow.com/robots.txt
    URL url = new URL(website + "/robots.txt");

    //List of your sub-links
    List<String> list;

    //Read the file with BufferedReader
    try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
        String subLink;
        list = new ArrayList<>();

        //Loop throw your file
        while ((subLink = in.readLine()) != null) {

            //Check if the sub-link is match with this regex, if yes then add it to your list
            if (subLink.matches("Disallow: \\/\\w+\\/")) {
                list.add(website + "/" + subLink.replace("Disallow: /", ""));
            }else{
                System.out.println("not match");
            }
        }
    }

    //Print your result
    System.out.println(list);
}