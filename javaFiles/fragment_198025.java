String uri =
    "http://api.flurry.com/eventMetrics/Event?apiAccessCode=?????&apiKey=??????&startDate=2011-2-28&endDate=2011-3-1&eventName=Tip%20Calculated";

URL url = new URL(uri);
HttpURLConnection connection =
    (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
connection.setRequestProperty("Accept", "application/xml");

InputStream xml = connection.getInputStream();

DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse(xml);