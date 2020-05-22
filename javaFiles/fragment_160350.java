public static class Location {
    private final int locationId;
    private final String locationDesc;

    public Location(final int locationId, final String locationDesc)
    {
        this.locationId = locationId;
        this.locationDesc = locationDesc;
    }

    @Override
    public int hashCode()
    {
        return locationId;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        final Location other = (Location) obj;
        return locationId == other.locationId;
    }
}