@Override
public boolean hasNext() {
    if (step < 0 && val >= a)
        return true;
    else if (step > 0 && val <= b)
        return true;
    return false;
}