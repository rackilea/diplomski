private static final String url = "website";

public void getLatestUpdate() throws IOException {
    try {
        URL addr = new URL(url);
        URLConnection con = addr.openConnection();
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            Pattern p = Pattern.compile("<span itemprop=.*?</span>");
            Pattern p2 = Pattern.compile(">.*?<");
            Matcher m = p.matcher(inputLine);
            Matcher m2;
            while (m.find()) {
                m2 = p2.matcher(m.group());
                while (m2.find()) {
                    data.add(m2.group().replaceAll("<", "").replaceAll(">", "").replaceAll("&", "").replaceAll("#", "").replaceAll(";", "").replaceAll("3", "3"));
                }
            }
        }
        in.close();
        addr = null;
        con = null;

        message("(" + data.get(3) + ")" + ", at " + data.get(4));
    } catch (Exception e) {
        System.out.println("Error getting data from website.");
        e.printStackTrace();
    }
}