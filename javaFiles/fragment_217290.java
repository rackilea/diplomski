InputStream in = channelExec.getInputStream();

// ...

BufferedReader reader = new BufferedReader(new InputStreamReader(in));
String line;
while ((line = reader.readLine()) != null)
{
}

session.disconnect();