class Item {
    private String name;
    private String amount;

    public Item(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() { 
        return this.name;
    }

    public String getAmount() {
        return this.amount;
    }

    @Override
    public boolean equals(Object other) {
        if ( other == this )
            return true;

        if ( other == null )
            return false;

        if ( other.getClass() != this.getClass() )
            return false;

        Item otherItem = (Item) other;
        return otherItem.getName().equals(this.name);
    }
}