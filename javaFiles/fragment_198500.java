ArrayList<User> dataList; // ** User is a custom Class
....
FileInputStream userfile = new FileInputStream("C:\\user.dat");
ObjectInputStream usersteam = new ObjectInputStream(userfile);
dataList = (ArrayList<User>)usersteam.readObject();
usersteam.close();