public static Client pollFirst(long time, TimeUnit timeUnit) throws InterruptedException{
    Client client=null;
        client = getInstance().queue.poll(time, timeUnit);

    if (client!=null) { // removed semicolon from this line
        reportClientRetrievedFromQueue(client.getName());
    }
    return client;
}