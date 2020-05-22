private Position getPositionFromScreenPoint( double x, double y ) {
      final View           vw        = _sceneController.getView();
      final Line           ray       = vw.computeRayFromScreenPoint( x, y );
      final Vec4           origin    = ray.getOrigin();
      final Vec4           direction = ray.getDirection().normalize3();
      final Globe          globe     = _sceneController.getModel().getGlobe();
      final double         gme       = globe.getMaxElevation();
      final Intersection[] inters    = globe.intersect( new Line( origin, direction ), gme );
      if( inters != null ) {
         final Vec4     pt  = inters[0].getIntersectionPoint();
         final Position pos = globe.computePositionFromPoint( pt );
         return pos;
      }
      return null;
   }