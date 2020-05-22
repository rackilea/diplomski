int maxFriends = 0;
int maxFriendsLine = 0;
int currentLine = 0;
while (..) {
    int friends = tokenizeString(..);
    if (friends > maxFriends) {
        maxFriendsLine = currentLine;
        maxFriends = friends;
    }
    currentLine++;
}