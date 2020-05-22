try (
    AutoDeletableFile file = new AutoDeletableFile("myfile.txt");
) {
    // deal with file
}
// do nothing here. The file will be deleted automatically since its close() method actually deletes the file.