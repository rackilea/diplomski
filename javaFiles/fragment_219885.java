public int hashCode() {
    int hash = 17;
    hash = hash * 31 + field1Hash;
    hash = hash * 31 + field2Hash;
    hash = hash * 31 + field3Hash;
    hash = hash * 31 + field4Hash;
    ...
    return hash;
}