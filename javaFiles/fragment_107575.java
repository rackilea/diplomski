@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
public @Data class Event extends AbstractEntity {

    /* attributes are omitted */

    // all addressees are initially present in this map with response set to UNDEFINED
    // if user has received and read notification, than the response is updated to YES, NO, or MAYBE
    @Singular
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy="event", cascade = CascadeType.ALL)
    private List<EventUserAssociation> addressees = new ArrayList<>();

    /**
     * Add an addressee to the event.
     * Create an association object for the relationship and set its data.
     *
     * @param addressee a user to whom this event notification is addressed
     * @param response  his response.
     */
    public boolean addAddressee(User addressee, Response response) {
        EventUserAssociation association = new EventUserAssociation(this, addressee, response);
            // Add the association object to this event
        return this.addressees.add(association) &&
                // Also add the association object to the addressee.
                addressee.getEvents().add(association);
    }

    public List<User> getAddressees() {
        List<User> result = new ArrayList<>();
        for (EventUserAssociation association : addressees)
            result.add(association.getAttendee());
        return result;
    }

}