// Decode broken GIF image and write to disk
final String base64Gif = "[Base64 as provided by API]";
final byte[] sigImg = Base64.decodeBase64(base64Gif);
Path gifPath = Paths.get("C:/Temp/pod_1Z12345E5991872040.tmp.gif");
if (!Files.exists(gifPath)) {
    Files.createFile(gifPath);
}
Files.write(gifPath, sigImg, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

// Use the Java Process API to call ImageMagick (on Linux you would use the 'convert' binary)
ProcessBuilder procBuild = new ProcessBuilder();
procBuild.command("C:\\Program Files\\ImageMagick-7.0.9-Q16\\magick.exe", "C:\\Temp\\pod_1Z12345E5991872040.tmp.gif", "-coalesce", "C:\\Temp\\pod_1Z12345E5991872040.gif");
Process proc = procBuild.start();

// Wait for ImageMagick to complete its work
proc.waitFor();