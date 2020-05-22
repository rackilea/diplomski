public void filewrite(String filename)
{   
    int lines = 10 + randomnumbers.nextInt(11);
    String randomnumber = Integer.toString(1 + randomnumbers.nextInt(11));

    try {
        FileWriter writer = new FileWriter(filename, true);
    } catch (IOException e) {
        // handle it
    }
}