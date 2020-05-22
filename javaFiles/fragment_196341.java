Socket s;
try {
    s = new Socket(serverAddress, 9092);
}
catch (IOException e)
{
    // when error, try again after some delay
    Thread.sleep(500);
    s = new Socket(serverAddress, 9092);
}