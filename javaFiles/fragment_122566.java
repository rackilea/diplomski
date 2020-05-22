@Override
public int hashCode(){
    return Objects.hash(name, length, children);
}

@Override
public boolean equals(final Object obj){
    if(obj instanceof Bean){
        final Bean other = (Bean) obj;
        return Objects.equals(name, other.name)
            && length == other.length // special handling for primitives
            && Objects.equals(children, other.children);
    } else{
        return false;
    }
}