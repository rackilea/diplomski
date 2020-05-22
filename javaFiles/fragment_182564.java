/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rdf;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.FileManager;
import org.apache.jena.atlas.logging.LogCtl;
import org.apache.log4j.Logger;
import java.util.Scanner;
import org.apache.jena.atlas.io.IndentedWriter;
import org.apache.jena.atlas.logging.LogCtl;
import org.apache.log4j.Logger;

/**
*
* @author shroog
*/
public class JavaApplication14 {


// public static final String onto_file = "root-ontology.owl";
//    public static final String NL = System.getProperty("line.separator");
//    private static final Logger log = Logger.getLogger("disease");
   public static void main(String[] args) {
    //LogCtl.setCmdLogging();
       // create the simplest model there is
      // final Model m = ModelFactory.createDefaultModel();
       // use the file manager to read an RDF document into the model
       //FileManager.get().readModel(m, onto_file);

      OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
            FileManager.get().readModel( m, "root-ontology.owl" );

             String var="";
       System.out.println("Enter class name : ");
            Scanner sc = new Scanner(System.in);
          var = sc.nextLine();
            String queryString =        
                     "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "+
                               "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>  "+
                         " PREFIX  : <http://www.semanticweb.org/hp/ontologies/2016/2/disease-ontologies.owl#>"+
                       "select ?x " 
                        + 
                       "where { "+
                        "?x a :"+var+"}";



               Query query = QueryFactory.create(queryString);
               QueryExecution qee = QueryExecutionFactory.create(query,m);
                  ResultSet resultss =  qee.execSelect();
                                       String [] TXT= new String[20];
                  try{

            int i=0;
              while(resultss.hasNext()) {


                QuerySolution  bindingg =resultss.nextSolution();
                Resource suu=(Resource) bindingg.get("x");

                TXT[i]= suu.getLocalName();
                                    System.out.println(TXT[i]);
                                    i++;

                               }
                  } catch (ArrayIndexOutOfBoundsException e){}

                                       }


}