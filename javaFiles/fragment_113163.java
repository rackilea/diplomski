public static void main(String[] args){
    String fileName = "filename.extension";
    System.out.println("Old: " + fileName);
    String id = "thisIsAnID";
    String[] fileNameSplits = fileName.split("\\.");
    // extension is assumed to be the last part
    int extensionIndex = fileNameSplits.length - 1;
    // add extension to id
    System.out.println("New: " + id + "." + fileNameSplits[extensionIndex]);
}