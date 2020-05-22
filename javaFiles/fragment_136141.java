System.out.println("start updating db");
String myDBName = "myDB" ;

StardogDBMS dbms =
        //StardogDBMS.toServer("snarl://localhost:5820/")
        StardogDBMS.toServer("snarl://myRemoteServer:5820/")
        .credentials("admin", "admin".toCharArray()).login();

File file = new File("src\\main\\webapp\\test.rdf"))

System.out.println("creating " + myDBName);

dbms.disk(myDBName).create());
dbms.logout();

aConn = ConnectionConfiguration.to(myDBName) // the name of the db to connect to
            .credentials("admin", "admin") // the credentials with which to connect
            .url("snarl://myRemoteServer:5820/")
            .connect(); // now open the connection

    System.out.println("importing files to "+myDBName);
    aConn.begin();
    aConn.add().io().format(RDFFormat.RDFXML).stream(file);     
    aConn.commit();
    System.out.println("files imported to "+myDBName);

    System.out.println("DB Updated");