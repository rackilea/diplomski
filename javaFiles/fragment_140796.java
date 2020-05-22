URL url = new URL("http://server:port/service_path");
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setDoOutput(true);
connection.setInstanceFollowRedirects(false);
connection.setRequestMethod("POST");
connection.setRequestProperty("Content-Type", "application/xml");

OutputStream os = connection.getOutputStream();

JAXBContext jaxbContext = JAXBContext.newInstance(MyClass.class);
jaxbContext.createMarshaller().marshal(MyClass, os);
os.flush();