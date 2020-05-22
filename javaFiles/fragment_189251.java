// Set connection parameters; usually loaded from a properties file.
    String uri = "http://server:port/wsi/FNCEWS40MTOM/";
    String username = "username";
    String password = "password";

    // Make connection.
    Connection conn = Factory.Connection.getConnection(uri);
    Subject subject = UserContext.createSubject(conn, username, password, null);
    UserContext.get().pushSubject(subject);

    try
    {
        // Get default domain.
        Domain domain = Factory.Domain.fetchInstance(conn, null, null);
        System.out.println("Domain: " + domain.get_Name());

        // Get object stores for domain.
        ObjectStore os = Factory.ObjectStore.fetchInstance(domain, "OS_Name", null);

        // Build the query you want to use here
        // Add the attributes you want, the document class you're interested in, etc.
        String sqlstr = "SELECT [This], [createdBy], [createdDate] FROM [docClass] WHERE ([IsCurrentVersion] = TRUE) AND Document.This INFOLDER '/f1/f2'";

        SearchSQL sql = new SearchSQL(sqlstr)
        SearchScope scope = new SearchScope(os);
        IndependentObjectSet docs = scope.fetchObjects(sql, 1000, null, true);
        // Get the page iterator
        PageIterator p = docs.pageIterator();

        // Loop through each page
        while(p.nextPage())
        {
            // Loop through each item in the page
            for(Object objct : p.getCurrentPage())
            {
                // Get the document object and write Document Title
                Document doc = (Document)objct;
                Properties props = doc.getProperties();

                String creator = props.getStringValue("createdBy");
                Date creationDate = props.getDateTimeValue("creationDate");

                // Now that you have the values, do what you want with them :)
            }
        }
    }