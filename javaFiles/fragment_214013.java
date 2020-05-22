import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class SolrNestedSearch {

    static final String SOLR_URL = "http://localhost:8983/solr/collection1";

    public static void main ( String[] args ) throws Exception {

        HttpSolrServer solr = new HttpSolrServer( SOLR_URL );

        // Docs to submit
        Collection<SolrInputDocument> batch = new ArrayList<SolrInputDocument>();

        // Parent Doc 1, a person mamed John Jones
        SolrInputDocument person1 = new SolrInputDocument();
        person1.addField( "id",            "john_jones" );
        person1.addField( "content_type",  "person"     );
        // "_t" suffix tells Solr that it's text
        person1.addField( "first_name_t",  "John"       );
        person1.addField( "last_name_t",   "Jones"      );
        // states and history used in edismax examples
        person1.addField( "states_t",      "California Nevada Idaho Maine" );
        person1.addField( "history_t",     "safe accident accident accident accident accident" );

        // child docs, the vehicles he owns
        SolrInputDocument p1_car1 = new SolrInputDocument();
        p1_car1.addField( "id",            "jj_car1"    );
        p1_car1.addField( "content_type",  "car"        );
        // For cars "make" is an alias for "manufacturer"
        p1_car1.addField( "make_t",        "Honda"      );
        p1_car1.addField( "model_t",       "Accord"     );

        SolrInputDocument p1_car2 = new SolrInputDocument();
        p1_car2.addField( "id",            "jj_car2"    );
        p1_car2.addField( "content_type",  "car"        );
        p1_car2.addField( "make_t",        "Nissan"     );
        p1_car2.addField( "model_t",       "Maxima"     );

        SolrInputDocument p1_bike1 = new SolrInputDocument();
        p1_bike1.addField( "id",           "jj_bike1"   );
        p1_bike1.addField( "content_type", "bike"       );
        p1_bike1.addField( "make_t",       "Yamaha"     );
        p1_bike1.addField( "model_t",      "Passion"    );

        SolrInputDocument p1_bike2 = new SolrInputDocument();
        p1_bike2.addField( "id",           "jj_bike2"   );
        p1_bike2.addField( "content_type", "bike"       );
        p1_bike2.addField( "make_t",       "Peugeot"    );
        p1_bike2.addField( "model_t",      "Vivacity"   );

        // Add children to parent
        person1.addChildDocument( p1_car1  );
        person1.addChildDocument( p1_car2  );
        person1.addChildDocument( p1_bike1 );
        person1.addChildDocument( p1_bike2 );

        // Add parent to batch
        batch.add( person1 );


        // Parent Doc 2, person mamed Satish Smith
        SolrInputDocument person2 = new SolrInputDocument();
        person2.addField( "id",           "satish_smith" );
        person2.addField( "content_type", "person"       );
        person2.addField( "first_name_t", "Satish"       );
        person2.addField( "last_name_t",  "Smith"        );
        person2.addField( "states_t",     "California Texas California Maine Vermont Connecticut" );
        person2.addField( "history_t",    "safe safe safe safe safe safe safe safe accident" );

        // Vehicles (child docs)
        SolrInputDocument p2_car1 = new SolrInputDocument();
        p2_car1.addField( "id",            "ss_car1"     );
        p2_car1.addField( "content_type",  "car"         );
        p2_car1.addField( "make_t",        "Peugeot"     );
        p2_car1.addField( "model_t",       "iOn"         );
        SolrInputDocument p2_bike1 = new SolrInputDocument();
        p2_bike1.addField( "id",           "ss_bike1"    );
        p2_bike1.addField( "content_type", "bike"        );
        p2_bike1.addField( "make_t",       "Honda"       );
        p2_bike1.addField( "model_t",      "Spree"       );
        // link objects and add to batch
        person2.addChildDocument( p2_car1  );
        person2.addChildDocument( p2_bike1 );
        batch.add( person2 );

        System.out.println( "Adding batch of " + batch.size() + " parent docs" );

        // Submit as a group
        solr.add( batch );
        solr.commit();



        Map<String,String> params = new LinkedHashMap<>();
        params.put( "parent_filter", "content_type:person" );
        params.put( "defType", "edismax" );
        params.put( "qf", "history_t states_t^100" );
        doQuery(solr,
                "eDismax3: Drivers matching accidents and/or California, and all of their vehicles, boost on State",
                "California accident report",
                "{!parent which=$parent_filter}",
                "*,[child parentFilter=$parent_filter]",
                params );

    }


    static void doQuery( HttpSolrServer solr, String description, String queryStr, String optFilter,
            String optFields, Map<String,String>extraParams ) throws Exception
    {
        SolrQuery q = new SolrQuery( queryStr );
        if ( null!=optFilter ) {
            q.addFilterQuery( optFilter );
        }
        if ( null!=optFields ) { 
            q.setParam( "fl", optFields );   
        }
        else {
            q.addField( "*" );  
        }
        if ( null!=extraParams ) {
            for ( Entry<String,String> param : extraParams.entrySet() ) {
                q.set( param.getKey(), param.getValue() );
            }
        }

        // Run and show results
        QueryResponse rsp = solr.query( q );
        SolrDocumentList docs = rsp.getResults();
        long numFound = docs.getNumFound();
        System.out.println( "Matched: " + numFound );
        int docCounter = 0;
        for (SolrDocument doc : docs) {
            docCounter++;
            System.out.println( "Doc # " + docCounter );
            for ( Entry<String, Object> field : doc.entrySet() ) {
                String name = field.getKey();
                Object value = field.getValue();
                System.out.println( "\t" + name + "=" + value );
            }
            List<SolrDocument> childDocs = doc.getChildDocuments();
            if ( null!=childDocs ) {
                for ( SolrDocument child : childDocs ) {
                    System.out.println( "\tChild doc:" );
                    for ( Entry<String, Object> field : child.entrySet() ) {
                        String name = field.getKey();
                        Object value = field.getValue();
                        System.out.println( "\t\t" + name + "=" + value );
                    }
                }
            }
        }

        System.out.println( "Query URL:" );
        System.out.println( SOLR_URL + "/select?" + q );
    }
}