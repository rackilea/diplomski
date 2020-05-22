for (Iterator<Integer> iter = clients.keySet().iterator(); iter.hasNext(); )
{
    int key = iter.next();

    java.net.Socket client = clients.get(key);

    // Sending the response back to the client.
    // Note: Ideally you want all these in a try/catch/finally block
    OutputStream os = client.getOutputStream();
    OutputStreamWriter osw = new OutputStreamWriter(os);
    BufferedWriter bw = new BufferedWriter(osw);
    bw.write("Some message");
    bw.flush();
}