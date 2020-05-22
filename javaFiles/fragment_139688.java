@Override
public boolean equals(Object other){
    if (other == null) return false;
    if (other == this) return true;
    if (!(other instanceof MyClass))return false;
    MyClass otherMyClass = (MyClass)other;
    ...test other properties here...
}