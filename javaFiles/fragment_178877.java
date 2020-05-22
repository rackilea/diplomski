HandleMultipleClients hmc=new HandleMultipleClients();
hmc.Connect(sock);
try
{
    hmc.messagetospecificclients("192.168.1.102","apps");
}