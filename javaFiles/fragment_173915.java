public AppointmentsOverlay(Drawable defaultMarker, List<Address> addresses) {
        super(defaultMarker);
        populate(); // Add this
        locations=new ArrayList<OverlayItem>();
        convertAddressesToOverlayItems(addresses);
    }