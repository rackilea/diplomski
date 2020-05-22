File title1= new File(filename1);
 while (title1.exists()) //make sure the file doesn't exist
{
    System.out.println("The file " + filename1 +" already exists.");
    System.out.println("Please choose another name.");
    System.out.println("Enter the filename:");
    filename1=keyboard.nextLine();
    title1= new File(filename1);   
}