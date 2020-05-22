@Override
public boolean equals(Object obj) {
   if (!(obj instanceof Couple))
        return false;
    if (obj == this)
        return true;

    Couple couple = (Couple) obj;    
    return (this.v1 != null && this.v1.equals(couple.v1) 
            && this.v2 != null && this.v2.equals(couple.v2));
}