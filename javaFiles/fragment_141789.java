public boolean checkUserInDatabase(String username, String email) {
    boolean result = false;
    List<User> localArray = getUserList();

    System.out.println("List retrieved...Checking user in database"+ localArray);
    for (User u : localArray ) {
        if (u.getUsername().equals(username)) {
        return true;
        }
    }

return result;
}