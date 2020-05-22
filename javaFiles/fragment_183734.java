File rdfFile; // parameter, RDF file.
   repo = new SailRepository(new MemoryStore());
   repo.initialize();

   Thead loader = new Thread() {
      public void run() {
       try (RepositoryConnection con = repo.getConnection()) {
            con.add(rdfFile, null, rdfFormat);
       }
      }
   };
   Thead query = new Thread() {
      public void run() {
       try (RepositoryConnection con = repo.getConnection()) {
        conn.begin(IsolationLevels.READ_UNCOMMITTED);
        String query = "SELECT * WHERE ... "; 
        try(TupleQueryResult result = conn.prepareTupleQuery(query).evaluate()) {
           while (result.hasNext()) {
                ...
           }
        }
        conn.commit();
      }
   };
   loader.start(); 
   query.start();