//setup Session here 
...
session.connect();
...


Channel channel = session.openChannel("sftp");
channel.connect();
ChannelSftp sftpChannel = (ChannelSftp) channel;

...run sftp logic...

//close sessions here
sftpChannel.exit();
session.disconnect();