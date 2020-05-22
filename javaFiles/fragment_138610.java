public User returnUser() throws UserNotFoundException {

    try{
         return user = userList.get(user_id);
    }
    catch (Exception e) {
        throw new UserNotFoundException ("user " + user + " not found");
    }
}