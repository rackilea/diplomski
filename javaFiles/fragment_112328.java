SftpRemoteFileTemplate template = new SftpRemoteFileTemplate(sessionFactory);
PipedInputStream pipe = new PipedInputStream();
OutputStream outputStream = new PipedOutputStream(pipe);
template.execute(s -> {
    s.write(pipe, "/foo/bar.log");
    return null;
});