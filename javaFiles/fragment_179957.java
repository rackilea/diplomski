public boolean equals(Object o) {
    if (o == null) return false;
    if (o == this) return true;
    if (!(o instanceof Edge)) return false;
    Edge oEdge = (Edge) o;
    return this.source == oEdge.source && 
           this.destination == oEdge.destination && 
           this.weight == oEdge.weight;
}

public int hashCode(){
    return source * 3 + dest * 11 + weight * 13;
}