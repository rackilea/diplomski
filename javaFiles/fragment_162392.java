String[] lines = new String[11];  //11 players
    try (BufferedReader reader = new BufferedReader(new FileReader("file path here"))) {
        String line = null;
        int index = 0;
        while ((line = reader.readLine()) != null) {
            lines[index++] = line;
        }
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }