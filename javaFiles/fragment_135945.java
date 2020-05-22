if (list.contains(key)) {
    // not first time, so fire held
    onKeyHeld(key);
}
else {
    list.add(key);
    onKeyPressed(key);
}