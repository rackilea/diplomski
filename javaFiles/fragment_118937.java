try {
    // acknowledge client
    ObjectInputStream in = new ObjectInputStream(s.getInputStream());
    ObjectOutputStream out = new ObjectOutputStream(s.getOutStream());
    String msg = in.readObject().toString();
    System.out.println(msg+" is Connected"); //Show who's connected
    out.writeObject("success"); //Respond with success.
    // end acknowledge client

    String msg = "";
    while(!msg.equalsIgnoreCase("bye"))
    {
        msg = in.readObject().toString();
        System.out.println("Client Says - "+msg);
        out.writeObject("success");
    }
    in.close();
    out.close();
}
catch(Exception ex)
{
    ex.printStackTrace();
}