public boolean equals(Object that) {
    if ( this == that ) return true;
    if ( !(that instanceof Dog) ) return false;
    Dog dog = (Dog)that;
    // Assuming id is of Long type
    return this.id.longValue() == dog.id.longValue();
}