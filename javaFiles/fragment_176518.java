Iterator<Waypoint> iterator = mWaypoint.iterator();
    Waypoint waypoint;
    while (iterator.hasNext()) {
        waypoint = iterator.next();
        if (waypoint.getId() == 1) { // 1 is an example
            iterator.remove();
        }
    }