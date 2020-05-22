public Intent setType(String type) {
    mData = null;
    mType = type;
    return this;
}

public Intent setData(Uri data) {
    mData = data;
    mType = null;
    return this;
}