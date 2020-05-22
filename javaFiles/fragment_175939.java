while(true)
{
    String messaggio = (new String(ricevuta.getData()).trim());   
    System.out.println("Client says: " + messaggio);
    Checking();
}