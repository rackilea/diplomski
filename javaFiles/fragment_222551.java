public static void main(String args[]) {

    int count = 0;

    //you can store reference to Friend in an array
    Friend[] friends = new Friend[3];

    //in the loop, you make 3 new Friends
    while (count < 3) {
        friends[count] = new Friend();
        count++;
    }

    //Since they're instantiated and stored in the array, you can call their methods later
    friends[0].goodbye();
    //or
    friends[1].goodbye();
    //or
    friends[2].goodbye();
}