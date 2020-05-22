import jade.core.*;
import jade.core.behaviours.*;
import jade.domain.FIPAAgentManagement.*;
import jade.domain.FIPAException;
import jade.domain.DFService;
import jade.domain.FIPANames;
import jade.util.leap.Iterator;

/**
This is an example of an agent that plays the role of a sub-df by 
automatically registering with a parent DF.
Notice that exactly the same might be done by using the GUI of the DF.
<p>
This SUBDF inherits all the functionalities of the default DF, including
its GUI.
@author Giovanni Rimassa - Universita` di Parma
@version $Date: 2003-12-03 17:57:03 +0100 (mer, 03 dic 2003) $ $Revision: 4638 $
*/

public class SubDF2 extends jade.domain.df {


  public void setup() {

   // Input df name
   int len = 0;
   byte[] buffer = new byte[1024];

   try {

//     AID parentName = getDefaultDF();
        AID parentName = new AID("df@10.251.216.135:1099/JADE");
        parentName.addAddresses("http://NikhilChilwant:7778/acc");

     //Execute the setup of jade.domain.df which includes all the default behaviours of a df 
     //(i.e. register, unregister,modify, and search).
     super.setup();

     //Use this method to modify the current description of this df. 
     setDescriptionOfThisDF(getDescription());

     //Show the default Gui of a df.
     super.showGui();

     DFService.register(this,parentName,getDescription());
     addParent(parentName,getDescription());
         System.out.println("Agent: " + getName() + " federated with default df.");


         DFAgentDescription template = new DFAgentDescription();
            ServiceDescription templateSd = new ServiceDescription();
            templateSd.setType("weather-forecast");
            templateSd.addProperties(new Property("country", "Italy"));
            template.addServices(templateSd);

            SearchConstraints sc = new SearchConstraints();
            // We want to receive 10 results at most
            sc.setMaxResults(new Long(10));
            DFAgentDescription[] results = DFService.search(this,parentName, template, sc);
        /*  if (results.length > 0) {*/
                System.out.println("SUB DF ***Agent "+getLocalName()+" found the following weather-forecast services:");
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
                }/*}*/


                String serviceName = "unknown2";
                DFAgentDescription dfd = new DFAgentDescription();
                dfd.setName(getAID());
                ServiceDescription sd = new ServiceDescription();
                sd.setName(serviceName);
                sd.setType("weather-forecast2");
                // Agents that want to use this service need to "know" the weather-forecast-ontology
                sd.addOntologies("weather-forecast-ontology2");
                // Agents that want to use this service need to "speak" the FIPA-SL language
                sd.addLanguages(FIPANames.ContentLanguage.FIPA_SL);
                sd.addProperties(new Property("country2", "Italy2"));
                dfd.addServices(sd);

                DFService.register(this, parentName,dfd);

    }catch(FIPAException fe){fe.printStackTrace();}
  }

  private DFAgentDescription getDescription()
  {
     DFAgentDescription dfd = new DFAgentDescription();
     dfd.setName(getAID());
     ServiceDescription sd = new ServiceDescription();
     sd.setName(getLocalName() + "-sub-df");
     sd.setType("fipa-df");
     sd.addProtocols(FIPANames.InteractionProtocol.FIPA_REQUEST);
     sd.addOntologies("fipa-agent-management");
     sd.setOwnership("JADE");
     dfd.addServices(sd);
     return dfd;
  }

}