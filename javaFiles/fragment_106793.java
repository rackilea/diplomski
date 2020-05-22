@Override
public boolean equals(Object obj) {
    if(obj == this) return true; // Both objects have the same reference -> the objects are equal
    if((obj == null) || (obj.getClass() != this.getClass())) return false; // Classes are different -> objects are different
    Product p = (Product) obj; // Cast obj into Product
    if( (this.getPrice() == p.getPrice()) && (this.getName().equals(p.getName())) ) return true; // Price and name are the same -> both products are the same
    return false; // At this point the two objects can't be equal
}