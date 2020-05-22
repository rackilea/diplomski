ArrayList<User> users = new ArrayList<User>();
while (resultSet.next()) {
    User user = new User();
    user.setActionTime(resultSet.getString("action_time"));
    user.setUserAction(resultSet.getString("user_action"));
    user.setUserId(resultSet.getString("user_ip"));
    user.setUserIp(resultSet.getString("user_id"));
    users.add(user);
}
request.setAttribute("users", users);
RequestDispatcher view = request.getRequestDispatcher("calendar.jsp");
view.forward(request, response);