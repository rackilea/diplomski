Path path = Paths.get("filePath");
    List<String> lines = null;
    try {
        lines = Files.readAllLines(path);
    } catch (IOException e) {
        e.printStackTrace();
    }

    for (String line : lines) {
        System.out.println(Short.parseShort(line.substring(0, 16), 2));
        System.out.println(Short.parseShort(line.substring(16, 32), 2));
    }