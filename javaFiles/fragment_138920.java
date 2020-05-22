@Override
public boolean equals(Object obj) {
    if (obj == null) {
        return false;    
    }
    if (getClass() != obj.getClass()) {   // the object you are comparing to needs to have the same class (in your case it would be Product
        return false;    // return false if it has not the same class
    }
    final Product that = (Product) obj;        // now you are sure that it has the same class and you can cast without getting any error
    return this.name.equalsIgnoreCase(that.name); // if the two names are equal, the products are equal
}