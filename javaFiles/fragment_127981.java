@PreRemove
private void removeFromFollowers() {
   for (User user : followers) {
       user.removeFollowed(this);
   }
}