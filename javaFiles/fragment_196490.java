public ArrayList<String> getTicketDates(){
    ArrayList<String> theDateArray= new ArrayList<>();
    int i;
    String date = Ticket.getDate();    //This is not working.  See Reason Below.

    for (i=0; i<tickets.size(); i++){
        if(tickets.get(i).getPurchased()== false){
            theDateArray.add(date);
        }

    }
    return theDateArray;
}