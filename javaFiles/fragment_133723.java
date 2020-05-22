// First open URL connection (using JDK; similar with other libs)
URL url = new URL("http://somesite.com/requestEndPoint");
URLConnection connection = url.openConnection();
connection.setDoInput(true);  
connection.setDoOutput(true);  
// and other configuration if you want, timeouts etc
// then send JSON request
RequestObject request = ...; // POJO with getters or public fields
ObjectMapper mapper = new ObjectMapper(); // from org.codeahaus.jackson.map
mapper.writeValue(connection.getOutputStream(), request);
// and read response
ResponseObject response = mapper.readValue(connection.getInputStream(), ResponseObject.class);