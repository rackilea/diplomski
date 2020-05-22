Path dir = Paths.get("/srv/file_users", userName);
Files.createDirectories(dir);

Path file = dir.resolve("employee_status_downloader_" + unixTimestamp + ".csv");
try (CSVWriter writer = new CSVWriter(Files.newBufferedWriter(file))) {
    writer.writeAll(rsDemo, true);
}