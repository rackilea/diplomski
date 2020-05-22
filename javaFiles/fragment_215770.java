class SuperClass {
    // ...

    @Override
    public final boolean equals(final Object other) {
        if (other == this) { return true; }
        if (!(other instanceof SuperClass)) {
            return false;
        }
        final SuperClass otherSuperClass = (SuperClass) other;

        return compareOwnFields(otherSuperClass, false)  
        && otherSuperClass.compareOwnFields(this, true);
    }

    protected boolean compareOwnFields(final SuperClass other, 
        final boolean firstTraversal) {
        if (!firstTraversal) {
            return true;
        }
        if (field1 != other.getField1()) {
           return false;
        } 
        // compare other fields similarly ...
        return true;
    }

}    

class SubClass {
    // ...

    @Override
    protected boolean compareOwnFields(final SuperClass other, 
        final boolean firstTraversal) {
        if (other instanceof SubClass && !firstTraversal) {
            return true;
        if (other instanceof SubClass) {
            if (field1 != ((SubClass) other).getField1()) {
                return false;
            }
            // compare other fields similarly ...
            return super.compareOwnFields(other, firstTraversal);
        } else {
            if (field1 != DEFAULT_FIELD1) {
                return false;
            }
            // check other fields for default values similarly ..
            return super.compareOwnFields(other, firstTraversal);
        }
    }
}