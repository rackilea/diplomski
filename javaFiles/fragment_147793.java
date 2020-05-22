Socket socket = new Socket(url.getHost(), url.getPort());
DataOutputStream out = new DataOutputStream(socket.getOutputStream());
out.write(hardcodedRequest);
out.flush();

InputStream inStream = socket.getInputStream();

byte[] resp = new byte[hardcodedResponse.length];
int res = inStream.read(resp);

//Check if the response is the correct one.
if (!Arrays.equals(resp, hardcodedResponse) && res != hardcodedResponse.length) {

}
out.close();