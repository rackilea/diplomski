URL url = testOne.class.getResource("/test.sh");

if (url == null) {
    throw new Exception("Cannot find /test.sh");
}

final ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c",
    url.getPath() + " " + myarg);