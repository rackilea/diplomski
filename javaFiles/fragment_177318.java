line = diskScanner.nextLine(); // Scans files
//This condition with short circuit and skip the second condition if it is too short,
//so no exception will be thrown.
if (line.length() > 8 && line.substring(0,5).equals("PRINT")) { // Print function
    System.out.println(line.substring(8));
}