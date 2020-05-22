File[] files = new File("src/main/resources").listFiles();
for (File file in files) {
    if (file.getName().endsWith("properties")) {
        //Load and change...
    }
}