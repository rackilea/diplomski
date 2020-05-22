class myClass
{
    private List<Restaurant> locations;    

    private void distances()    
    {    
        List<Restaurant> locn = locations; // You don't really need to do this bit
        if (locn!= null) {    
            for (Restaurant a : locn) {
                a.setDistance(distanceToLocations(a));
            }
        }
    }

    private String distanceToLocations(Restaurant restaurant) {
        // returns string
    }
}