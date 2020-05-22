public void findDuplicateFiles(File[] files) {

    // In Java 8, the following loop can be replaced by:
    //Map<String, List<File>> filesByHash =
    //    Stream.of(files).filter(File::isFile).collect(
    //        Collectors.groupingBy(file -> MD5.asHex(MD5.getHash(file))));

    Map<String, List<File>> filesByHash = new HashMap<>();
    for (File file : files) {
        if (!file.isFile()) {
            continue;
        }

        String hash = MD5.asHex(MD5.getHash(file));

        List<File> filesForHash = filesByHash.get(hash);
        if (filesForHash == null) {
            filesByHash.put(hash, filesForHash = new ArrayList<File>());
        }

        filesForHash.add(file);
    }

    for (Map.Entry<String, List<File>> entry : filesByHash.entrySet()) {
        List<File> filesForHash = entry.getValue();
        if (filesForHash.size() > 1) {
            String hash = entry.getKey();
            System.out.printf("%,d files have hash %s:%n",
                filesForHash.size(), hash);

            for (File file : filesForHash) {
                System.out.println("  " + file);
            }
        }
    }
}