List<Ticket> ticketsList = infos.stream()
   .filter(info -> info.getTicketTypeList() != null)//filter the list if null
   .map(info -> info.getTicketTypeList())//get the tickettype list
   .flatMap(ticketsList -> ticketsList.stream())//convert to stream of tickets
   .filter(lowestPriceTicket -> 
       lowestPriceTicket.getCode().order() == 
          ticket.getCode().order())//check if it matches with the given ticket
   .collect(Collectors.toList());//now collect it to a List<Ticket>