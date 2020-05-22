public SSH(LoginCredentials creds, String command, String hostname) 
{
    ...
    this.connect(hostname);
}

...

private void connect(String hostname) throws JSchException {
    JSch jsch = new JSch();
    session = jsch.getSession(creds.getUser(), hostname, 22);
    ...
}