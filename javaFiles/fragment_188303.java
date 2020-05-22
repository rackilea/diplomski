public String toString() {

    if (isEmpty()) return "[]";
    String result = "[";

    result += q[f];

    for (int i = (f+1)%capacity; i != r; i = (i+1)%capacity) {
        result += ", " + q[i];
    }   

    return result + "]";

}