/** goToLocation
 * @param map - You GoogleMap reference
 * @param location - your LatLng value
 * @param zoom Float - ie. 15
 * @param b Boolean - Animate camera movement: true or false
 */
public void goToLocation(GoogleMap map, LatLng ll, float zoom, boolean b) {
    if (b == true) {
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(ll, zoom));
    } else {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(ll, zoom));
    }
}