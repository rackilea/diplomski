URLConnection connection = new URL(newURL).openConnection();
connection.setDoOutput(true);
// Set and/or copy request headers here based on current request?

InputStream input1 = request.getInputStream();
OutputStream output1 = connection.getOutputStream();
// Copy.

InputStream input2 = connection.getInputStream();
OutputStream output2 = response.getOutputStream();
// Copy.