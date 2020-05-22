if (citizens != length || citizens != length2) {
    /*If you decide to keep this, it should not be a "IndexOutOfBoundsException 
    (since no index was out of bounds) but should perhaps be a "IllegalArgumentException" 
    since you supplied it illegal arguments.*/
    throw new IndexOutOfBoundsException("Numebr of citizens do not match. Please enter numbers again");
} else if (citizens == length && citizens == length2) { ... }

with

if (citizens == length && citizens == length2) { ... }