XStream xstreamin = new XStream(new StaxDriver());
//you need to add this line
xstreamin.alias("account", Account.class);
//then the rest of your code...
Reader someReader = new FileReader("Accounts.xml");
ObjectInputStream in = xstreamin.createObjectInputStream(someReader);
accountsin = (ArrayList<Account>) in.readObject();
in.close();