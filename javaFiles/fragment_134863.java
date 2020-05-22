public int hashCode() {
    return (name + fatherName+ Id + filePath + age + address).hashCode();
}

public boolean equals(Object obj) {
    return ( hashCode() == obj.hashCode() );
}