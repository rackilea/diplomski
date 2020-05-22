URL url = new URL("urlAddress/dinfo.cgi");
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
connection.setRequestProperty("Cookie", "iR=7472571");

try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            StringBuilder builder = new StringBuilder();
            int cp;

            while ((cp = in.read()) != -1) {
                builder.append((char) cp);
            }

            return builder.toString();
}