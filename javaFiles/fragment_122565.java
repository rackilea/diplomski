@Override
public int hashCode(){
    return new HashCodeBuilder()
        .append(name)
        .append(length)
        .append(children)
        .toHashCode();
}

@Override
public boolean equals(final Object obj){
    if(obj instanceof Bean){
        final Bean other = (Bean) obj;
        return new EqualsBuilder()
            .append(name, other.name)
            .append(length, other.length)
            .append(children, other.children)
            .isEquals();
    } else{
        return false;
    }
}