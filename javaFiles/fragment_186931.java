if(request.getParameter("id") != null) {

int id = Integer.valueOf(request.getParameter("id"));
EmployeeDAO.addTrips(id,tripsInitialvalue);

} else {
  //decide what to do when id is null
}