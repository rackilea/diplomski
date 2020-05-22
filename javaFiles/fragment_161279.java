String user = "your_user_name";
    String pass ="your_pass_word";

    String sharedFolder="shared";
    String path="smb://ip_address/"+sharedFolder+"/test.txt";
    NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("",user, pass);
    SmbFile smbFile = new SmbFile(path,auth);
    SmbFileOutputStream smbfos = new SmbFileOutputStream(smbFile);
    smbfos.write("testing....and writing to a file".getBytes());
    System.out.println("completed ...nice !");