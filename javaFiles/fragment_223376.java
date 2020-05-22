//...some of your code class level
clientArrayListUpdaterHelper delta;
//...moar code
public Server() throws RemoteException
{
//...more of your code
delta = new clientArrayListUpdaterHelper();
gui = new ServerGui(delta);
//...more of your code