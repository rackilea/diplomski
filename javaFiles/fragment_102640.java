boolean doesFileExists = false;
for (File file : FileNames) {
    if (file.getName().equals("File 001.txt")) {
        System.out.println("it exists");
        doesFileExists = true;
        break;
    }
}
if (!doesFileExists) {
    System.out.println("it doesn't exist");
}