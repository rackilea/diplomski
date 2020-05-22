public class AssignmentResult {
    private Object value;

    /**
     * Set the result value
     * @param value result value
     */
    protected void setValue(Object value) {
        this.value = value;
    }

    /**
     * Returns the result value
     * @return the result value
     */
    public Object getValue() {
        return this.value;
    } 
}