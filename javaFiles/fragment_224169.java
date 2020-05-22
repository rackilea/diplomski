if (move > FastMath.abs(d)) {
    a = b;
} else {
    if (d>0) {
        a+=move;
    } else {
        a-=move;
    }
}