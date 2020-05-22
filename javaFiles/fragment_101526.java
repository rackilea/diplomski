...
private boolean init = false;
...
if (sec == 0 && init) {
    sec = 60;
    min--;
} else if (!init) {
    init = true;
}
...