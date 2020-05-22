public Location saveLocation(Location loc) {
    eManager.clear();
    eManager.setFlushMode(FlushModeType.COMMIT);
    //eManager.setFlushMode(FlushModeType.COMMIT);
    Query q = eManager.createNamedQuery("findLocationByLatLong");
    q.setParameter("latitude", loc.getLatitude());
    q.setParameter("longitude", loc.getLongitude());
    try {
        Location dummy = (Location) q.getSingleResult();
        eManager.clear();
        // eManager.flush();
        return dummy;
    } catch (NoResultException ex) {
        Logger.getLogger("WeatherRecorderBean.class").log(Level.WARNING,
                ex.getMessage());
        eManager.clear();
        eManager.merge(loc);
        eManager.flush();
        return loc;
    } catch (Exception ex) {
        Logger.getLogger("WeatherRecorderBean.class").log(Level.WARNING, "Should never get here! "+ex.getMessage());
        return null;
    }
}