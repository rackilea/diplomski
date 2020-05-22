//Before the for loop, in a wider scope, declare the User:
User user;
//Then, in the for loop, initialize it:
user = accounts.get(i);
//As it was declared outside the for loop, it can be accessed later:
textWindow.append("localhost." + "User ID: " + user.getConnectionID() + " at " + getDateTime() + " > ");//or however you wish to format it