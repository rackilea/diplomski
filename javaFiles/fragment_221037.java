public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.github.com/search/repositories?q=reactive");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        System.out.println(con.getResponseMessage());
}