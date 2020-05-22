Color baseColor = lightBlue;
Color topColor = darkBlue;

int skyHeight = 500;
int windowHeight = 200;
int windowLocation = ...; // something betweeen 0 and skyHeight - windowHeight;
Color windowBottomColor = baseColor.copy().lerp(topColor, windowLocation / skyHeight);
Color windowTopColor = baseColor.copy().lerp(topColor, (windowLocation + windowHeight) / skyHeight);