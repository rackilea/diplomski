interface Data {
    String getString();
    MutableData toMutable();
}
class MutableData implements Data {
    String getString() {...}
    void setString(String s) {...}
    Data toImmutable() {...}
    MutableData clone() {...}
}
class ImmutableData implements Data {...}