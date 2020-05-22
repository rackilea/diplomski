if (action!=null && action.equalsIgnoreCase("delete")){
       int userId = Integer.parseInt(request.getParameter("userId"));
    dao.deleteUser(userId);
    forward = LIST_USER;
    request.setAttribute("users", dao.getAllUsers());    
} else if (action!=null && action.equalsIgnoreCase("edit")){
    forward = INSERT_OR_EDIT;
    int userId = Integer.parseInt(request.getParameter("userId"));
    User user = dao.getUserById(userId);
    request.setAttribute("user", user);
} else if (action!=null && action.equalsIgnoreCase("listUser")){
    forward = LIST_USER;
    request.setAttribute("users", dao.getAllUsers());
} else {
    forward = INSERT_OR_EDIT;
}