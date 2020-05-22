@Entity(AccessType.Property)
class MyClass {
    // Other fields.

    private transient String strangeField;

    public String getStrangeField() {
        return strangeField;
    }

    public void setStrangeField(String strangeField) {
        this.strangeField = strangeField;
    }
}