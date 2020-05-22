while(noWallInFront) {
    walk();
    if (sawFriend) {
        sayHi();
        noWallInFront = false;
    }
}