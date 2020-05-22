URL url = new URL("http://im.twitvid.com/api/uploadAndPost");
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setDoOutput(true);
connection.setInstanceFollowRedirects(false);
connection.setRequestMethod("POST");
connection.setRequestProperty("Content-Type", "application/xml");

OutputStream os = connection.getOutputStream();

TransformerFactory tf = TransformerFactory.newInstance();
Transformer transformer = tf.newTransformer();
FileReader fileReader = new FileReader("filename.xml");
StreamSource source = new StreamSource(fileReader);
StreamResult result = new StreamResult(os);
transformer.transform(source, result);

os.flush();
connection.getResponseCode();
connection.disconnect();