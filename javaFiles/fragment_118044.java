@Override
public int compareTo(Shape o) {
    if (this.getArea() > o.getArea())
        return 1;
    else if (this.getArea() == o.getArea())
        return 0;
    else
        return -1;
}