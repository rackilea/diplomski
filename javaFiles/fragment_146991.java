function checkSymmetry(Curve curve1, Curve curve2, Vector c, float maxDist) {
    // reflect one curve
    Curve curve2refl = reflect(curve2, c);
    // compute curve distance
    float d = dist(curve1, curve2refl);
    // check if distance is below threshold
    return d < maxDist;