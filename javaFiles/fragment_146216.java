XYPoint _xypoint = new XYPoint();
             Coordinates coords = getCoordinates();
         coords.setLatitude(Double.parseDouble((String) _latitude);
         coords.setLongitude(Double.parseDouble((String) _longitude);


         convertWorldToField(coords,_xypoint);
             int x = _xypoint.x;
             int y = _xypoint.y;