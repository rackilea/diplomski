long minTimestamp = Long.MAX_VALUE; // definitely greater than any timestamp you will ever find
long maxTimestamp = 0;
int count = 0;

try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("DIRECTORY PATH"))) {
    for(Path path: directoryStream) {
        if (!(Files.isDirectory(path) || path.toString().endsWith("\\databaseinfo.xml") || path.toString().endsWith(".log"))) {
            long lastModified = path.toFile().lastModified();
            if (lastModified > 0L) { // check that no error occurred
                if (lastModified < minTimestamp) minTimestamp = lastModified; // new minimum
                if (maxTimestamp < lastModified) maxTimestamp = lastModified; // new maximum
            }
            count = count + 1;
        }
    }

} catch (IOException e) {
    e.printStackTrace();
}
System.out.println(count);
double filesPerHour = 0;
if (maxTimestamp != minTimestamp) { // avoid division by 0
    filesPerHour = (double) count * 60 * 60 * 1000 / (maxTimestamp - minTimestamp); // 60 * 60 * 1000 = milliseconds in one hour
}
System.out.println(filesPerHour);