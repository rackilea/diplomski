public void onBattleEnded(BattleEndedEvent e)
{
    writeToLog();   
    throw new RuntimeException(new IOException());
}

public void writeToLog()
{
    //Create a new RobocodeFileWriter.      
    RobocodeFileWriter fileWriter = new RobocodeFileWriter("./logs/test.txt");
    for (String line : outputLog)
    {
        fileWriter.write(line);
        fileWriter.write(System.getProperty("line.seperator"));
    }       
    throw new new RuntimeException(new IOException());
}