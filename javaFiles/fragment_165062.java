class OutSave
{

    File output = new File("output.txt");

    public static void main()
    {
        print("Print this");
        print("And save this");
    }

    public static print(String str)
    {
        System.out.println(str);
        writeToFile(output, str);
    }

    public void writeToFile(File file, String str) {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(str);
        bw.close();
    }
}