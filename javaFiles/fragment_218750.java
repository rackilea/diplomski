private static String getResourceByName(string path) {
    try {
        return ClassPathResource(path).getFile().getAbsolutePath();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}