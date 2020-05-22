@XmlAccessorType(XmlAccessType.NONE)
static class TestGeneric<T> {
    @XmlAttribute public boolean isRequired;
    @XmlElement public T value;

    public TestGeneric() {
    }

    public TestGeneric(boolean isRequired) {
        this.isRequired = isRequired;
    }
}