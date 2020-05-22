String url = "smb://yourhost/yourpath/";
NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, "user", "password");
SmbFile dir = new SmbFile(url, auth);
for (SmbFile f : dir.listFiles())
{
    System.out.println(f.getName());
}