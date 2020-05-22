<script>


    function initialize() {

        var mapOptions = {
                zoom: 8,
                center: new google.maps.LatLng(22.978624, 87.747803)                    
        };
        var map = new google.maps.Map(document.getElementById('map-canvas'),mapOptions);
        <% 
            for(int i=0;i<polutionList.size();i++){
                String companyLatLong   =   polutionList.get(i).getLatLong();

                    String multiLatLong[]   =   companyLatLong.split(",");%>
                    var polyCoords  =   [];

                    <%for(int j=0;j<multiLatLong.length;j++){
                        String latLong[]        =   multiLatLong[j].split(" ");
                        double lat              =   Double.parseDouble(latLong[0]);
                        double longi            =   Double.parseDouble(latLong[1]);
                    %>

                polyCoords.push(new google.maps.LatLng(<%= lat%>, <%= longi%>));

                    <%
                      }
                    %> 


                var polygons =new google.maps.Polygon({
                        paths: polyCoords,
                        strokeColor: '#FF0000',
                        strokeOpacity: 0.8,
                        strokeWeight: 2,
                        fillColor: '#FF0000',
                        fillOpacity: 0.35
                    });
                  polygons.setMap(map);
        <%
        }
        %>

    }

    google.maps.event.addDomListener(window, 'load', initialize);

</script>