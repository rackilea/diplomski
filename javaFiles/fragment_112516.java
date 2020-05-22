ServerClass

while(true)
{
    new Thread(new ClientClass(server.accept()));//Maybe you want to store it for future comunication
}