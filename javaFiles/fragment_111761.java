public static void main(String[] args) throws IOException {

    String sFromLang="<add the value here>";
    String sWikiID="Iași";
    String sArticleEncoded = URLEncoder.encode(sWikiID, "UTF-8");
    String sURL = "http://" + sFromLang + ".wikipedia.org" + "/w/api.php?action=query&prop=langlinks&titles=" + sArticleEncoded + "&redirects=&lllimit=400";
    URL url = new URL(sURL);
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
}