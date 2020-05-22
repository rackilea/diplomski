@Entity
class Person {

    @ManyToOne(targetEntity = Address.class)
    IAddress address;

    public Person(String name, IAddress address) {
        this.name = name;
        setAddress(address);
    }

    public IAddress getAddress() {
        return address == null ? NullObjectAddress.INSTANCE : address;
    }

    public void setAddress(IAddress address) {
        this.address = address instanceof NullObjectAddress ? null : address;
    }
}