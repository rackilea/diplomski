String statement =  "SELECT datastream.column1,  rel.column2"                           + 
                    "FROM   Datastream.Measure AS datastream, "                         +
                           "sql:database_alias ['SELECT column2 "                       +
                                                "FROM \"SchemaX\".\"TableY\" ] AS rel";

//Install this query in the engine
EPStatement queryEngineObject = esperEngine.getEPAdministrator().createEPL(statement);  

//Associate a Listener to this query
MyQueryListener listener = new MyQueryListener(); //that implements UpdateListener Interface
queryEngineObject.addListener(listener);