@Override
public int compareTo(Point arg0) {
    if(this.x == arg0.x && this.y == arg0.y)
        return 0;
    return -1;
}