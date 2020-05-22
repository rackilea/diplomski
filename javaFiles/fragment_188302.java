public String toString() {

    if (isEmpty()) return "[]";
    String result = "[";

    for (int i = f; i != r; i = (i+1)%capacity) {
        result += q[i] + ", ";
    }   

    return result.substring(0,result.length()-2) + "]";
    // a bit dirty but gets the job done
}