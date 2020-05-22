@Override
public String toString() {
    String values = ""; // you could also use a StringBuilder here
    values += "Status: " + status + "\n";
    values += "Message: " + message + "\n";
    // ....
    return values;
}