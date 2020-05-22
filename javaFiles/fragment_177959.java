System.out.println("Does file exist: "+ copy.exists());
System.out.println("Is file locked: "+ copy.canWrite());
while (copy.canWrite() != true){
    //stall your application until the file is accessible.
}
//now load the file
Image image = ImageIO.read(copy);