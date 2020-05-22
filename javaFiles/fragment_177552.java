Path file = Paths.get("/Users/jokrasa/Documents/workspace_traffic/javaReviewFeb28/src/TEST/","testy.txt");
        try {
            Files.createDirectory(file.getParent());
            Files.createFile(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }