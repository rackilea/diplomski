public QueryExecution query(){

        String stringa = "http://dbpedia.org/resource/Fred_Guy";

        ParameterizedSparqlString qs = new ParameterizedSparqlString( "" +
                "prefix dbpediaont: <http://dbpedia.org/ontology/>\n" +
                "prefix dbpedia: <http://dbpedia.org/resource/>\n" +
                "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +  
                "select ?resource where {\n" +
                "?mat rdf:type ?resource\n" +
                "filter strstarts(str(?resource), dbpediaont:)\n" +
                "}" );


        Resource risorsa = ResourceFactory.createResource(stringa);
        qs.setParam( "mat", risorsa );

        //System.out.println( qs );

        QueryExecution exec = QueryExecutionFactory.sparqlService( "http://dbpedia.org/sparql", qs.asQuery() );


        ResultSet results = ResultSetFactory.copyResults( exec.execSelect() );

        while ( results.hasNext() ) {

            System.out.println( results.next().get( "resource" ));
        }

        // A simpler way of printing the results.
        ResultSetFormatter.out( results );

        return exec;

    }