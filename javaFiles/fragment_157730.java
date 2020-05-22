public class InventorySlot {
    private Object object;
    private int amount;

// CONSTRUCTOR (assuming you don't instanciate filled slots)
    public InventorySlot() {
        this.setObject(null);
        this.setAmount(0);
    }

// GETTERS AND SETTERS
    public Object getObject() {
        return this.object;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setObject(final Object object) {
        this.object = object;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
        }

// METHOD THAT ADDS NEW ITEM IF MATCHES. RETURNS BOOLEAN TO TELL IF SUCCEEDED
        public bool addIfMatches(final Object object) {
            if (this.getObject.getItemNum() == object.getItemNum()) {
                this.setAmount(this.getAmount++);
                return true;
            } else {
                return false;
            }
        }

// AND OTHER USEFUL METHODS...

}