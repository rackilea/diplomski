URL url = new URL(URL + "?" + address + "&sensor=false");
URLConnection conn = url.openConnection();
ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
IOUtils.copy(conn.getInputStream(), output);
output.close();
System.out.println(output.toString());