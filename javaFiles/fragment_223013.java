frUsername = new FileReader("Username.txt");
brUsername = new BufferedReader(frUsername);
while (true){
  final String checkUsername = brUsername.readLine();
  if (checkUsername == null) {break;}
  if (checkUsername.equals(usernameInput)) {correctUsername = true;}
}