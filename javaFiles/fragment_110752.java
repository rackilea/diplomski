public static String readFileFromResources(String fileName) throws IOException {
    try (Scanner sc = new Scanner(new ClassPathResource(fileName).getInputStream())) {
        sc.useDelimiter("\\A");
        return sc.next();
    }
}