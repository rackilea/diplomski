public static int PLAYER1 = 1;
ObjectOutputStream oos = new ObjectOutputStream(player1.getOutputStream());
oos.writeInt(PLAYER1);

oos.flush();

// OR

oos.close();