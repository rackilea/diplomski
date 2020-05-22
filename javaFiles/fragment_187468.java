// Assuming that the cover and message arrays are of type chars

String messageStr = "";
// Since the message and cover arrays should be the same length, it doesn't matter which one is used to get the length of the loop
for (int i = 0; i < messageArray.length; i++) {
    for (int j = 0; j < messageArray[i].length; j++) {
        if (cover[i][j] == 'O') {
            messageStr += messageArray[i][j];
        }
    }
}