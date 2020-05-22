function initialize() {
        var myLatLng = new google.maps.LatLng(-33.890542, 151.274856);

        var map = new google.maps.Map(document.getElementById("map-canvas"), {
          center: myLatLng,
          zoom: 10
        });
        var image = 'https://google-developers.appspot.com/maps/documentation/javascript/examples/full/images/beachflag.png';

        var beachMarker = new google.maps.Marker({
          position: myLatLng,
          map: map,
          icon: image
        });
      }
      google.maps.event.addDomListener(window, 'load', initialize);