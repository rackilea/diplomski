JSch jsch = new JSch();

// Here privateKey is a file path like "/home/me/.ssh/secret_rsa "
// passphrase is passed as a string like "mysecr"
jsch.addIdentity(privateKey, passphrase);

session = jsch.getSession(user, host, port);
session.setConfig("StrictHostKeyChecking", "no"); 
// Or yes, up to you. If yes, JSch locks to the server identity so it cannot
// be swapped by another with the same IP.

session.connect();
channel = session.openChannel("shell");
out = channel.getOutputStream();
channel.connect();