if      (hsb[1] < 0.1 && hsb[2] > 0.9) nearlyWhite();
else if (hsb[2] < 0.1) nearlyBlack();
else {
    float deg = hsb[0]*360;
    if      (deg >=   0 && deg <  30) red();
    else if (deg >=  30 && deg <  90) yellow();
    else if (deg >=  90 && deg < 150) green();
    else if (deg >= 150 && deg < 210) cyan();
    else if (deg >= 210 && deg < 270) blue();
    else if (deg >= 270 && deg < 330) magenta();
    else red();
}