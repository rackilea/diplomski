private boolean keyPresent(String key) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(keyPath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals(key)) {
                return true;
            }
        }
        return false;
    }
}