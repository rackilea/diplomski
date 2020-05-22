// This example adds a predefined symbol (an arrow) to a polyline.
// Setting offset to 100% places the arrow at the end of the line.

function initMap() {
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 6,
    center: {
      lat: 20.291,
      lng: 153.027
    },
    mapTypeId: google.maps.MapTypeId.TERRAIN
  });

  // [START region_polyline]
  // Define a symbol using a predefined path (an arrow)
  // supplied by the Google Maps JavaScript API.
  var lineSymbol = {
    path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW
  };

  // Create the polyline and add the symbol via the 'icons' property.
  var line = new google.maps.Polyline({
    path: [{
      lat: 22.291,
      lng: 153.027
    }, {
      lat: 18.291,
      lng: 153.027
    }],
    icons: [{
      icon: lineSymbol,
      offset: '100%'
    }],
    map: map
  });
  // [END region_polyline]
}
google.maps.event.addDomListener(window, 'load', initMap);