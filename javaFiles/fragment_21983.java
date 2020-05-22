@Override
public boolean equals(Object startObject) {
    if (this == startObject) return true;
    if (startObject == null || getClass() != startObject.getClass()) return false;
    Star star = (Star) startObject;
    return x == star.x &&
            y == star.y;
}