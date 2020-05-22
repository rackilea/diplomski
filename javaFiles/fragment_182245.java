public void filewrite(String filename) throws IOException
{   
    int lines = 10 + randomnumbers.nextInt(11);
    String randomnumber = Integer.toString(1 + randomnumbers.nextInt(11));

    FileWriter writer = new FileWriter(filename, true);
    // use it
}