public ResponseEntity<ResponseWrapper> uploadFile(@RequestParam("uploads") MultipartFile file) throws Exception {
JSch ssh = new JSch();
Session session = ssh.getSession("username", "Servername", 22);

config.put("StrictHostKeyChecking", "no");
session.setConfig(config);
session.setPassword("*****");
session.connect();
Channel channel = session.openChannel("sftp");
channel.connect();

sftp = (ChannelSftp) channel;
OutputStream os = sftp.put("/storedfiles/outputfile.zip");

AESEncrypter aesEncrypter = new AESEncrypterBC();
aze=new AesZipFileEncrypter(os, aesEncrypter);
aze.add(file.getOriginalFilename(), file.getInputStream(), "test123");
if(aze != null) {
 aze.close();
}    
}