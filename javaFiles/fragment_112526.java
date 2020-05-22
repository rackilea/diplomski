ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
InputStream in = channelExec.getInputStream();
channelExec.setCommand("date +%m%d%Y%H%M%S"); //Date format could be changed to your desired format
channelExec.connect();

BufferedReader reader = new BufferedReader(new InputStreamReader(in));
String line;
int index = 0;
while ((line = reader.readLine()) != null) {
   System.out.println(++index + " : " + line);
}

channelExec.disconnect();