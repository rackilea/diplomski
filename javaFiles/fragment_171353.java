public BoundingBox findBoundingBoxForGivenLocations(ArrayList<LatLng> coordinates)
{
    double west = 0.0;
    double east = 0.0;
    double north = 0.0;
    double south = 0.0;

    for (int lc = 0; lc < coordinates.size(); lc++)
    {
        LatLng loc = coordinates.get(lc);
        if (lc == 0)
        {
            north = loc.getLatitude();
            south = loc.getLatitude();
            west = loc.getLongitude();
            east = loc.getLongitude();
        }
        else
        {
            if (loc.getLatitude() > north)
            {
                north = loc.getLatitude();
            }
            else if (loc.getLatitude() < south)
            {
                south = loc.getLatitude();
            }
            if (loc.getLongitude() < west)
            {
                west = loc.getLongitude();
            }
            else if (loc.getLongitude() > east)
            {
                east = loc.getLongitude();
            }
        }
    }

    // OPTIONAL - Add some extra "padding" for better map display
    double padding = 0.01;
    north = north + padding;
    south = south - padding;
    west = west - padding;
    east = east + padding;

    return new BoundingBox(north, east, south, west);
}