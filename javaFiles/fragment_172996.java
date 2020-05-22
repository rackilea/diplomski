while (true) {
    g.wakeUp();
    if (stopTheLoop()) break;
    g.goToSchool();
    if (stopTheLoop()) break;
    g.beforeLunch();
    if (stopTheLoop()) break;
    ...
}