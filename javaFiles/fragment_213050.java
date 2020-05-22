private void findMusic(String input, ObjectOutputStream toClient)
{
    logoff();
    String[] names = input.split("[.]");
    clientManagerTemp.logger("Someone request song: " + names[2] + ".mp3");

    File musicFile = AudioUtil.getSoundFile("src/Resources/Songs/" + names[2]+ ".mp3");
    int fileLength = (int) musicFile.length();
    byte[] buffer = new byte[fileLength];

    try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(musicFile)))
    {
        bis.read(buffer, 0, buffer.length);

        clientManagerTemp.logger("Sending " + "src/Resources/Songs/" + names[2]+ ".mp3" + "(" + buffer.length + " bytes)");
        //write the file to the client

        toClient.writeInt(fileLength);
        toClient.write(buffer,0, buffer.length);
        toClient.flush();

        clientManagerTemp.logger("Finished sending");

    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
}