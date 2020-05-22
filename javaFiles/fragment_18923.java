ProcessBuilder processBuilder = new ProcessBuilder("nohup", "sh", "restart.sh");
try {
    processBuilder.directory(new File(System.getProperty("user.dir")));
    processBuilder.redirectErrorStream(false);
    processBuilder.start();
} catch (IOException e) {
    e.printStackTrace();
}