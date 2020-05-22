public boolean sendMessageAtTime(Message msg, long uptimeMillis)
{
    //...
    if (queue != null) 
    {
        msg.target = this; // here the reference to the handler is assigned 
        sent = queue.enqueueMessage(msg, uptimeMillis);
    }
    //...
}