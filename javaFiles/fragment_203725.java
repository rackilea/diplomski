JSch jsch = new JSch();
  Session session = jsch.getSession(user, host, 22);
  ...
  String command = "scp -f "+rfile;
  Channel channel = session.openChannel("exec");
  ((ChannelExec)channel).setCommand(command);

  InputStream in = channel.getInputStream();
  channel.connect();

  // "in" contains the input stream of the file