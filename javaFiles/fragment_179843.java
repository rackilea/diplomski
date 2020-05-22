<%!
    RouteDAO routeDAO=new RouteDAO();
    Route route=new Route(login, 
            origin.getAdresse(), 
            ""+origin.getcoordX(), 
            ""+origin.getCoordY(), 
            destination.getAdresse(),
            ""+destination.getcoordX(),
            ""+destination.getCoordY(),
            itineraire.getTempsSec()
            );
    routeDAO.addRoute(route);
%>