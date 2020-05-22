@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "listing_id")
Listing listing;

@OneToMany(mappedBy = "servicePeriod",
        fetch = FetchType.EAGER,
        cascade = CascadeType.PERSIST)
Set<ListingLineItem> lineItems;