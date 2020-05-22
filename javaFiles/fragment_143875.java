Object command = request.getPortletSession().getAttribute(RESERVATION_OF_BOOKS_COMMAND_SESSION_NAME);

if(!(command instanceof ReservationOfBooksCommand)){
        request.getPortletSession().removeAttribute(RESERVATION_OF_BOOKS_COMMAND_SESSION_NAME);
}else{
   ...
}