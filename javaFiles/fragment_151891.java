void friend(FacebookUser newFriend) {
    System.out.println(friends.size());
    if (friends.contains(newFriend)) {
        System.out.println("That person is already in your friends list.");
        return;
    }

    friends.add(newFriend);
}