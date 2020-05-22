try {
    //Simple reading of bytes
    FileInputStream fileInputStream = new FileInputStream("path to file");
    byte[] arr = new byte[1024];
    int actualBytesRead = fileInputStream.read(arr, 0, arr.length);

    //Can read characters and lines now
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
    String lineRead = bufferedReader.readLine();
    char [] charArrr = new char[1024];
    int actulCharsRead = bufferedReader.read(charArrr, 0, charArrr.length);

    //File reader allows reading of characters from a file
    FileReader fileReader = new FileReader("path to file");
    actulCharsRead = fileReader.read(charArrr, 0, charArrr.length);

    //It is a good idea to wrap a bufferedReader around a fileReader
    BufferedReader betterFileReader = new BufferedReader(new FileReader(""));
    lineRead = betterFileReader.readLine();
    actulCharsRead = betterFileReader.read(charArrr, 0, charArrr.length);

    //allows reading int, long, short, byte, line etc. Scanner tends to be very slow
    Scanner scanner = new Scanner("path to file");
    //can also give inputStream as source
    scanner = new Scanner(System.in);
    long valueRead = scanner.nextLong();

    //might wanna check out javadoc for more info

} catch (IOException e) {
    e.printStackTrace();
}