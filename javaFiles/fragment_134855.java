public static void WriteFile(String data){
    try {
        out = new BufferedWriter(new FileWriter("AddUser.txt", true));
        out.write(data);
        out.newLine();
        out.close();
    }
    catch(IOException e)
    {
        System.out.println("There was a problem:" + e);
    }
}