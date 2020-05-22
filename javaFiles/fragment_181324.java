public boolean equals(Bigram b) {
    return b.first == first && b.second == second;
}

@Override public boolean equals(Object o) {
    if (!(o instanceof Bigram)) return false;
    return equals((Bigram)o);
}