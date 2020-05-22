HttpStatus(int value, String reasonPhrase) {
    this.value = value;
    this.reasonPhrase = reasonPhrase;
}
...
@Override
public String toString() {
    return Integer.toString(this.value);
}