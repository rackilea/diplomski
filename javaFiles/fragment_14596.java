if(game!=null) {
    rd = request.getRequestDispatcher("/success.jsp");
    request.setAttribute("Game", game);
    request.setAttribute("Item", "gameID");
} else {
    log.log(Level.SEVERE, "Cannot retrieve game: ");
    rd = request.getRequestDispatcher("/error.jsp");
    rd.forward(request, response);
}