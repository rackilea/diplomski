additional:



private boolean userWantsToQuit = false;
private List<TicketAgent> avaibleAgents = new ArrayList<TicketAgent>();
private List<TicketAgent> usedAgents= new ArrayList<TicketAgent>();
private List<TickeType> boughtTickets= new ArrayList<TicketType>();

main(...){

   agents.add(new TicketAgent("Sam"));
   agents.add(new TicketAgent("wise"));
   agents.add(new TicketAgent("gamgee"));

   do{

   usedAgents.add(askUserForAgent()); //extra static method
   boughtTickets.add(askUserForType(agent)); //extra static method
   userWantsToQuit = askUserToQuit();//extra static method
   }while(!userWantsToQuit);

   displayAgentSummary(usedAgents);
   displayTicketSummary(boughtTickets);
}

[...]

public static displayAgentSummary(List<TicketAgent> agents)
{
    for(TicketAgent agent : agents)
    {
       System.out.println("Served by: " + agent.getName());
    }
}

public static displayTicketSummary(List<TicketType> tickets)
{
    float totalPrice = 0;
    for(TicketType ticket : tickets)
    {
       totalPrice =+ ticket.getPrice();
       System.out.println("You bought a " + ticket.getName() + " for " + ticket.getPrice()";
    }
    System.out.println("You bought tickets in total for " + totalPrice + " dollar".
}