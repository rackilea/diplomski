@Override
public Integer next() {
    int ret = val;
    val += step;
    return val;
}