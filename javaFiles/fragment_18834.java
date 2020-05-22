for (int i = 0; i < latpoints.length; i++) {
    if (i == 0) {
        poly.moveTo(latpoints[i], lonpoints[i]);
    }
    else {
        poly.lineTo(latpoints[i], lonpoints[i]);
    }
}
poly.closePath();