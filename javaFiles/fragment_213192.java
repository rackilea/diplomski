String fileUrl = "smb://netserver/some/path/to/file.xls";

Properties cifsProps = new Properties();
cifsProps.setProperty("jcifs.smb.client.domain", "my.domain.int");
cifsProps.setProperty("jcifs.smb.client.username", USER_NAME);
cifsProps.setProperty("jcifs.smb.client.password", PASSWORD);

Configuration config = new PropertyConfiguration(cifsProps);
BaseContext context = new BaseContext(config);
SmbResource resource = context.get(fileUrl);

if (!(resource instanceof SmbFile)) {
    throw new CIFSException("File URL does not point to a file on a network share");
}

try (InputStream in = ((SmbFile) resource).getInputStream()) {
    // TODO read from in
} finally {
    context.close();
}