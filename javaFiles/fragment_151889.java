int size = friends.size();
for (int i = 0; i < size; i++) {
   if (friends.get(i).equals(newFriend)) {
      System.out.println("That person is already in your friends list.");
      break;
   } else if (!friends.get(i).equals(newFriend) && i == friends.size() - 1) {
      friends.add(newFriend);
   }
}