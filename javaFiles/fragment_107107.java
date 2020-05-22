public static void main(String[] args) throws IOException {
    System.out.println(new File("KingOfAxes.png").getAbsolutePath()); // Try this to pinpoint your issue
    File king = new File("KingOfAxes.png");

    if(king.canRead()){ // Check if your file exists and is readable before you use it
        JavaAssignmentPanel KingOfAxes = new JavaAssignmentPanel("Diamonds", "King", 13, ImageIO.read(new File("KingOfAxes.png")));
    } else{
        throw new IOException(king.getName() + " is not readable!"); // Not readable -> Throw exception
    }
    System.out.println("King");
}