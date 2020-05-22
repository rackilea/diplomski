@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (a ^ (a >>> 32));
    result = prime * result + (int) (b ^ (b >>> 32));
    result = prime * result + (int) (c ^ (c >>> 32));
    return result;
}