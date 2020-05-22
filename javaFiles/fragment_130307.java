@Embedded
    @AttributeOverrides({
            @AttributeOverride(name="addressLine1", column=@Column(name="USER_ADDRESS_LINE_1")),
            @AttributeOverride(name="addressLine2", column=@Column(name="USER_ADDRESS_LINE_2"))
            })
    private Address address;