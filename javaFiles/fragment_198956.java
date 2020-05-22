public class Ticket
    extends ActionType {

    @XmlElementWrapper(name = "Tickets")
    @XmlElement(name = "Ticket")
    protected List<Ticket> tickets;

    @XmlElement(name = "TotalNumOfTickets")
    protected Integer totalNumofTickets;

    public Integer getTotalNumofTickets() {
        return totalNumofTickets;
    }

    public void setTotalNumofTickets(Integer totalNumoftokens) {
        this.totalNumofTickets = totalNumoftickets;
    }

}