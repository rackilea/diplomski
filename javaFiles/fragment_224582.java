boolean grow = true;

public void SuperSizeCircle() {

    if (XDiameter >= 200) {
        grow = false;
    }
    if (XDiameter <= 20) {
        grow = true;
    }

    if (grow) {
        XDiameter += 2;
        YDiameter += 2;
    } else {
        XDiameter -= 2;
        YDiameter -= 2;
    }
}