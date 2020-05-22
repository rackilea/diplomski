AGServer server = new AGServer(SERVER_URL, USERNAME, PASSWORD);
AGServer server2 = new AGServer(SERVER_URL2, USERNAME2, PASSWORD2);

AGRepository repo1 = server.getCatalog(CATALOG_ID).openRepository("repo1");
AGRepository repo2 = server2.getCatalog(CATALOG_ID).openRepository("repo2");

Federation federation = new Federation();
federation.addMember(repo1);
federation.addMember(repo2);
federation.setReadOnly(true); 

SailRepository rainbowRepo  = new SailRepository(federation);
rainbowRepo .initialize();

SailRepositoryConnection rainbowConn  =  rainbowRepo .getConnection(); //for querying and updating the contents of the repository.