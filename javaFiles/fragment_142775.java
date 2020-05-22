@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    HandComponent that = (HandComponent) o;
    return mType == that.mType &&
            mCard == that.mCard &&
            mSource == that.mSource;
}

@Override
public int hashCode() {

    return Objects.hash(mType, mCard, mSource);
}