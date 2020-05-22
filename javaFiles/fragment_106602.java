String name = request.getParameter("name");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
String ssv = request.getParameter("ssv");

// Do the necessary validations here and then ..

User user = new User(name, email, phone, Long.valueOf(ssv));

// Now you have an User javabean with the necessary information.
// Do with it whatever you want. E.g. saving in database.

userDAO.save(user);