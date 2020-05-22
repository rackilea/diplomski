while(noWallInFront) {
    walk();
    if (sawFriend) {
        sayHi();
        break;
    }
}