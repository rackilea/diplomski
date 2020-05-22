package examples.yellowPages;

import jade.core.Agent;
import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.util.leap.Iterator;

/**
   This example shows how to search for services provided by other agents 
   and advertised in the Yellow Pages catalogue managed by the DF agent.
   In this case in particular we search for agents providing a 
   "Weather-forecast" service.
   @author Giovanni Caire - TILAB
 */
public class DFSearchAgent extends Agent {

  protected void setup() {
    // Search for services of type "weather-forecast"
    System.out.println("Agent "+getLocalName()+" searching for services of type \"weather-forecast\"");
    try {
        // Build the description used as template for the search
        DFAgentDescription template = new DFAgentDescription();
        ServiceDescription templateSd = new ServiceDescription();
        templateSd.setType("weather-forecast");
        template.addServices(templateSd);

        SearchConstraints sc = new SearchConstraints();
        // We want to receive 10 results at most
        sc.setMaxResults(new Long(10));

        DFAgentDescription[] results = DFService.search(this, template, sc);
        if (results.length > 0) {
            System.out.println("Agent "+getLocalName()+" found the following weather-forecast services:");
            for (int i = 0; i < results.length; ++i) {
                DFAgentDescription dfd = results[i];
                AID provider = dfd.getName();
                // The same agent may provide several services; we are only interested
                // in the weather-forcast one
                Iterator it = dfd.getAllServices();
                while (it.hasNext()) {
                    ServiceDescription sd = (ServiceDescription) it.next();
                    if (sd.getType().equals("weather-forecast")) {
                        System.out.println("- Service \""+sd.getName()+"\" provided by agent "+provider.getName());
                    }
                }
            }
        }   
        else {
            System.out.println("Agent "+getLocalName()+" did not find any weather-forecast service");
        }
    }
    catch (FIPAException fe) {
        fe.printStackTrace();
    }
  } 
}