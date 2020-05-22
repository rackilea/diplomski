@Entity
public class Customer {

    @OneToMany
    @JoinColumn(name = "customer_id")
    @MapKeyColumn(name = "ticket_type")
    @MapKeyEnumerated(EnumType.String)
    private Map<TicketType, Ticket> tickets;

    // we will not expose the tickets collection
    // the fact it is a @OneToMany is then transparent to all client code

    public Ticket getOwnTicket(){
        return tickets.get(TicketType.O);
    }

    public Ticket getReferrerTicket(){
        return tickets.get(TicketType.R); 
    }

    public void setOwnTicket(Ticket ticket){
        //ticket.setType(TicketType.O); //may not be required
        tickets.put(TicketType.O, ticket);
    }

    public void setReferrerTicket(Ticket ticket){
        //ticket.setType(TicketType.R); //may not be required
        tickets.put(TicketType.R, ticket);
    }
}