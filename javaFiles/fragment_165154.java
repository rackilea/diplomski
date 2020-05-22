Charset charset = null;
try (InputStream is = new FileInputStream(file)) {
    Charset charset = Charset.forName(SidFileUtils.charsetDetection(is));
}
if (charset != null) {
    ...
}