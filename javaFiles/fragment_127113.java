Users[] someUsers = {user1, user2, user3};
List<Users> userList = new ArrayList<Users>(Arrays.asList(someUsers));
Comparator<Users> comparator = new Comparator<Users>() {
    @Override
    public int compare(Users left, Users right) {
        return left.firstName.compareTo(right.firstName);
    }
};
Collections.sort(userList, comparator);