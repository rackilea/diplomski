@Override
public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof MyDate)) return false;
    MyDate d = (MyDate)o;
    return this.day == d.day && this.month == d.month && this.year == d.year;
}

@Override
public int hashCode() {
    return ((day * 31) + month) * 31 + year; // 31=prime number
}