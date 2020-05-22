PrintWriter toServer;
    Properties clientProps = new Properties();

//  ... code to populate the properties and to 
//      construct toServer from the socket ...

    clientProps.store(toServer, null);
    toServer.write('\u001A'); // this is an old-school ASCII end-of-file
    toServer.flush();