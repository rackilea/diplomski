private List<Integer> clonedTicketNumbersList = new ArrayList<Integer>();

public Ticket(ArrayList<Integer> ticketNumbers, String name) {
    this.ticketNumbers = ticketNumbers;
    this.name = name;
    for(Integer ticketNum : ticketNumbers) {
      clonedTicketNumbersList.add(ticketNum );
    }
    System.out.print("Are the numbers being passed:" + ticketNumbers + "\n");
}

@Override
public String toString() {
    String output = "Name: " + name + "\nNumbers: " + clonedTicketNumbersList + "\n\n";

    return output;
}