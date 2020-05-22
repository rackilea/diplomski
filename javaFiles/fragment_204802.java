@Id
@Column(name = "ticket", nullable = false, insertable = false, updatable = false)
@GenericGenerator(
    name = "custom-sequence",
    strategy = "your.package.CustomGenerator"
)
@GeneratedValue(generator = "custom-sequence")
public String getTicketNum() {
    return ticketNum;
}