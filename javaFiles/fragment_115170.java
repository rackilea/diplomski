if (finalDistance > 10) {
    dmgMulti = dmgMulti;
}
else if (finalDistance < 1) { // Here!
    dmgMulti = dmgMulti + 0.5;
}
else {
    dmgMulti = dmgMulti + (0.5/finalDistance);
}