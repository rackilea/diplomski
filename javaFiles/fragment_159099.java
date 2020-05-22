boolean containsPoint(Point p) {

    for (int i = 0; i < this.length; i++)
    {
        if (pointsCovered.get(i).equals(p)) {
            return true;
        }
    }

    return false;
}