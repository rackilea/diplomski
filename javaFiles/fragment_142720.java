@Override
    public boolean equals(Object object) {
        return (object == this)
                || (object instanceof Double)
                && (doubleToLongBits(this.value) == doubleToLongBits(((Double) object).value));
    }