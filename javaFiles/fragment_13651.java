package com.weebly.foxgenesis.src;

public interface ChatReciever 
{
    /**
     * gets the IP address of the host
     * @return String IP address
     */
    public String getHost();

    /**
     * gets the port of the host
     * @return Integer port of host
     */
    public int getPort();

    /**
     * sends a message from the server to the implementing class
     * @param msg message from the server
     */
    public void handle(String msg);

    /**
     * sends an error to the implementing class
     * @param errorMsg error message
     */
    public void handleError(String errorMsg);

    /**
     * Sends a message to the log
     * @param msg message to send
     */
    public void handleLog(Object msg);
}