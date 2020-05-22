Channel channel = session.getStreamForwarder(remoteHost, remotePort);
[...]
InputStream in = channel.getInputStream();
OutputStream out = channel.getOutputStream();
[...]
while ((numRead = is.read(bytes)) >= 0)
    out.write(bytes, 0, numRead);
[...]
channel.disconnect();
session.disconnect();
[...]
BufferedReader reader = new BufferedReader(new InputStreamReader(in));
for (String line; (line = reader.readLine()) != null;){