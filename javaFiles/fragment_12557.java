@Override
public void printResults(List<File> files) {
    files.sort((file1,file2) -> (int)(file1.length()-file2.length())); // This will NOT work correctly if any of the files are over 2.7 GB in size.
    List<File> largest = files.subList(0, files.size() > 10 ? 10 : files.size());
    System.out.println("Largest files:");
    for(File file : largest) {
        System.out.println(file.getName() + " (" + file.length() + " bytes)");
    }
}