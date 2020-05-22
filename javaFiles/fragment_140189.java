try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*")) {
    for (Path entry: stream) {
        System.out.println(entry.toString()+" has size "+Files.size(entry)
             +" and date "+Files.getLastModifiedTime(entry).toString());
    }
} catch (DirectoryIteratorException ex) {
    // do some error processing
}