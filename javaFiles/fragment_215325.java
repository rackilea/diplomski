package examples.yellowPages;

    import jade.core.Agent;
    import jade.core.AID;
    import jade.domain.DFService;
    import jade.domain.FIPAException;
    import jade.domain.FIPANames;
    import jade.domain.FIPAAgentManagement.DFAgentDescription;
    import jade.domain.FIPAAgentManagement.ServiceDescription;
    import jade.domain.FIPAAgentManagement.Property;

    /**
       This example shows how to register an application specific service in the Yellow Pages
       catalogue managed by the DF Agent so that other agents can dynamically discover it.
       In this case in particular we register a "Weather-forecast" service for 
       Italy. The name of this service is specified as a command line argument.
       @author Giovanni Caire - TILAB
     */
    public class DFRegisterAgent extends Agent {

      protected void setup() {
        String serviceName = "unknown";

        // Read the name of the service to register as an argument
        Object[] args = getArguments();
        if (args != null && args.length > 0) {
            serviceName = (String) args[0];
        }

        // Register the service
        System.out.println("Agent "+getLocalName()+" registering service \""+serviceName+"\" of type \"weather-forecast\"");
        try {
            DFAgentDescription dfd = new DFAgentDescription();
            dfd.setName(getAID());
            ServiceDescription sd = new ServiceDescription();
            sd.setName(serviceName);
            sd.setType("weather-forecast");
            // Agents that want to use this service need to "know" the weather-forecast-ontology
            sd.addOntologies("weather-forecast-ontology");
            // Agents that want to use this service need to "speak" the FIPA-SL language
            sd.addLanguages(FIPANames.ContentLanguage.FIPA_SL);
            sd.addProperties(new Property("country", "Italy"));
            dfd.addServices(sd);

            DFService.register(this, dfd);
        }
        catch (FIPAException fe) {
            fe.printStackTrace();
        }
      } 
    }