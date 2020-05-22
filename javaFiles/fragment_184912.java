public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
        // Create URL
        String urllink = "http://dev.virtualearth.net/REST/v1/Locations?o=xml&culture=en-US&postalCode=2811&key=AvTXuyNkBKfm4wFGPxSDfA6jvN0dNlq6OhAg8wuw4zFLokJFgv8ivclIkq1nJTIo";
        URL url = new URL(urllink);
        StringBuffer sb = new StringBuffer();

        // Create a connection.
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setRequestProperty("Content-type", "application/json");
        urlConnection.setAllowUserInteraction(true);

        urlConnection.connect();

        InputStream stream = urlConnection.getInputStream();
        InputStreamReader isReader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(isReader);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            sb.append(line);
        }

        System.out.println(sb.toString());

        stream.close();
        br.close();
        urlConnection.disconnect();


    } catch (Exception e) {
        System.out.println("Exception:: " + e.getMessage());
    }
}