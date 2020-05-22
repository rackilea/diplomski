if (id.matches("[a-zA-Z]{3}-[0-9]{4}")) {
    this.id = id;
} else { 
    throw new IllegalArgumentException("Inventory ID must be in the "
        + "form of ABC-1234");
}