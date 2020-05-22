public class BookingDetail {
private Set<LookupFacility> lookupFacilities = new HashSet<LookupFacility>();
private Set<LookupFoodItem> lookupFoodItems = new HashSet<LookupFoodItem>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookingDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    public Set<LookupFacility> getLookupFacilities() {
        return lookupFacilities;
    }

    public void setLookupFacilities(final Set<LookupFacility> lookupFacilities) {
        this.lookupFacilities = lookupFacilities;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookingDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    public Set<LookupFoodItem> getLookupFoodItems() {
        return lookupFoodItems;
    }

    public void setLookupFoodItems(final Set<LookupFoodItem> lookupFoodItems) {
        this.lookupFoodItems = lookupFoodItems;
    }
}