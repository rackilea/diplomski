// preprocess
foreach (light) {
    // find all pixels p on the scene reachable from the light
}
// then render the whole scene...
foreach (point p to be shaded) {
    foreach (light) {
        // simply look up into what was calculated before...
        if (p is visible by the light)
            // p is lit
        else
            // p is in shadow
    }
 }