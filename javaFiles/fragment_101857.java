@Override
public boolean equals(Object o) { 
    if (o == this) { 
        return true; 
    } 
    if (!(o instanceof Money)) { 
        return false; 
    }
    Money other = (Money) o; 
    ... // Your code goes here
}

@Override
public int hashCode() {
    return Objects.hash(fAmount, fCurrency);
}