while(searchUser.hasNextLine()){
  //read the tokens first ignoring tag tokens
  searchUser.next();//ignore "First Name"
  storeFirst = searchUser.next().split(" ")[0];//split the 3 words and take 1st
  storeLast = searchUser.next().split(" ")[0];//split the 2 words and take 1st
  storeEmail = searchUser.next().split(" ")[0];//split the 2 words and take 1st
  storePassword = searchUser.next().split(" ")[0];//split the 2 words and take 1st
  //read and ignore remaining text including the new line character in the end
  searchUser.nextLine();

  Person person = new Person(storeFirst, storeLast, storeEmail, storePassword);
  usersArray.add(person);
}