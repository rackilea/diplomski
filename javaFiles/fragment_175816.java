JSch jSch = new JSch();
  Session session = jSch.getSession(user, host, 22);
  session.setPassword(password);
  Properties config = new Properties();
  session.setConfig(config);

   session.connect();

   Channel channel = session.openChannel("sftp");
   channel.connect();
   sftp = (ChannelSftp) channel;

   try {

       sftp.cd("/your/tomcat/dir/wars");

       File file = getWarFile();
       sftp.put(new FileInputStream(file), file.getName());

   } catch (SftpException e) {
       e.printStackTrace();
   }