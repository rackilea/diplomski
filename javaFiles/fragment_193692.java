// get database values
Field[] fields = user.getClass().getDeclaredFields();

// create an object to populate:
DBUserValues user = new DBUserValues();
user.setUserName(fields[0]);
user.serFirstName(fields[1]);