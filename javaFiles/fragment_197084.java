Path path = Paths.get("D:\\TestFolder");
    if (Files.exists(path)) {
        System.out.println("exist");
    }
    if (Files.notExists(path)) {
        System.out.println("not exist");
    }