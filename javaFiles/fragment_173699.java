ExampleListener sendMessageListener = new ExampleListener()
{
    public void onTaskCompleted(boolean success)
    {
        if(success)
            sendMessage();
    }
}