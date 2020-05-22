@Override
public boolean equals(Object o) { // Note the argument type
    if (!(o instanceof Registration)) {
        return false;
    }
    Registration other = (Registration) o;
    return getIdentifier().equals(other.getIdentifier()) && 
           getProvince().equals(other.getProvince());    
}