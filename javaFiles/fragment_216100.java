Leaderboard c = new Leaderboard();
Class cls = c.getClass();

// finds resource relative to the class location
URL url = cls.getResource("/Other/Leaderboard.txt");
System.out.println("Value = " + url);

// finds resource relative to the class location
url = cls.getResource("/Trial and Error/resources/Other/Leaderboard.txt");
System.out.println("Value = " + url);