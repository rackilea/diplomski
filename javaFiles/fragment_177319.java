line = diskScanner.nextLine(); // Scans files
try {
if (line.substring(0,5).equals("PRINT")) { // Print function
    System.out.println(line.substring(8));
}
} catch (IndexOutOfBoundsException e) {
    //Do Something...
}