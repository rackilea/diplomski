Properties prop = new Properties();
prop.load(new FileInputStream("player.properties"));

//get the property value and print it out
System.out.println(prop.getProperty("player.coinBank"));
System.out.println(prop.getProperty("player.ammo"));