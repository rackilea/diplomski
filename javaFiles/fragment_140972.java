public boolean equals(Object other) {
    (if other == null || !(other instanceof SecondClass)) 
        return false;
    else
        return this.value == ((SecondClass) other).value;
}