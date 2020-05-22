<%
  User user = (User)session.getAttribute("user");
  Message message = new Message(request.getParameter("message"));
  message.setOwner(user);
  FactoryDAO.getInstance().getMessageDAO().update(message);
%>