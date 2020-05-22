public static boolean exists (String urlName) throws IOException {
    try {
        new URL(urlName).openStream().close();
        return true;
    } catch (IOException e) {
        return false;
    }
}