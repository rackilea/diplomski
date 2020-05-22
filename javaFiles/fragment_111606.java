class GeoReadingAscendingComparator implements Comparator<GeoReading>
{

    @Override
    public int compare( GeoReading o1 , GeoReading o2 )
    {
        int localDateCompare = o1.localDate.compareTo( o2.localDate );
        if ( localDateCompare != 0 ) { // If not equal on this component, so compare on this.
            return localDateCompare;
        }

        int latitudeCompare = o1.latitude.compareTo( o2.latitude );
        if ( latitudeCompare != 0 ) { // If not equal on this component, so compare on this.
            return latitudeCompare;
        }

        return o1.longitude.compareTo( o2.longitude );

    }
}