class SkiMarker(mapView: MapView, tag:Tag) : Marker(mapView) {
    var tag: Tag = tag
        set(newTag){
            field = newTag  // `field` is a keyword
        }
}