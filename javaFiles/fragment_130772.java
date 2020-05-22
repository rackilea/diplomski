File file = new File(input); //here you make a filehandler - not a filesystem file.

if(!file.exists()) {
    file.createNewFile(); // create your file on the file system
} 

Scanner scan = new Scanner(new FileInputStream(file)); // read from file system.