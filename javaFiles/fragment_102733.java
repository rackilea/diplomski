@Override
public int hashCode() {
    int hash = 17;
    int hashMultiplikator = 79;
    int hashSum = first.hashCode() + second.hashCode();
    hash = hashMultiplikator * hash * hashSum;
    return hash;
}