@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + move1;
    result = prime * result + move2;
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Move other = (Move) obj;
    if (move1 != other.move1)
        return false;
    if (move2 != other.move2)
        return false;
    return true;
}