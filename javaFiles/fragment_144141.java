try {
    final ProcessBuilder processBuilder = new ProcessBuilder("/usr/bin/osascript",
            "-e", "tell app \"Terminal\"",
            "-e", "set currentTab to do script " +
            "(\"/usr/bin/ssh -o CheckHostIP=no -o TCPKeepAlive=yes -o StrictHostKeyChecking=no -o ServerAliveInterval=120 -o ServerAliveCountMax=100 -i ~/.aws/.ec2/dublin.pem ubuntu@" +
            selectedRow.get(publicDnsNameIndex).getValue() + "\")",
            "-e", "end tell");
    final Process process = processBuilder.start();
    process.waitFor();

} catch (Exception e) {
    e.printStackTrace();
}