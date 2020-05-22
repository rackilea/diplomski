@ManyToOne
@JoinColumn(name = "idaddress", referencedColumnName = "idaddress", nullable = false,
            cascade = CascadeType.PERSIST)
public Address getAddress() {
    return address;
}