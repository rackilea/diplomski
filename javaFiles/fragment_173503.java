// for each User we got back
    for (User user: response.getUsers()) {

        // get the location of the User
        GeoPoint userLocation = new GeoPoint(
                (int) (user.getLatitude() * 1E6),
                (int) (user.getLongitude() * 1E6));

        // create a map representation of the User
        UserOnMap userOnMap = new UserOnMap(user.getUserId(),
                user.getFirstName(), user.getLastName());

        // add the user to the list
        usersOnMap.add(userOnMap);
    }

    // set the overlay to reference this new list
    m_usersOverlay.setUsers(usersOnMap);

    // get the current list of map overlays
    List<Overlay> m_mapOverlays = m_mapView.getOverlays();
    m_mapOverlays.clear();
    m_mapOverlays.add(m_usersOverlay);
    m_mapView.invalidate();