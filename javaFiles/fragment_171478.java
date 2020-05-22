if (stringPool.contains(this))
    return stringPool.get(this);
else {
    stringPool.put(this, this);
    return this;
}