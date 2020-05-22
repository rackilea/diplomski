if (leftDisplacement > 0 && rightDisplacement < 0 && bottomDisplacement > 0 && topDisplacement < 0) {
    return 1; // Inside
}
if (leftDisplacement < 0 || rightDisplacement > 0 || bottomDisplacement < 0 || topDisplacement > 0) {
    return -1; // Outside
}
return 0; // On Rectangle