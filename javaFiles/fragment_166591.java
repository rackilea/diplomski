//...
String line = in.nextLine(); // Scanner will block waiting for user to hit enter
for (String word : line.split(" ")){
    if (word.equals("the")) {
        the++;
    }
//...