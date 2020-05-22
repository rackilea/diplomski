public void removeUser(String username) {
     Iterator<User> itr = people.iterator();
     while (itr.hasNext()) {
          Users element = (User) itr.next();
          if (element.getUsername().equals(username)) {
               itr.remove(); // REMOVE THIS FROM Iterator
          }
     }
}