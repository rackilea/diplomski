public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when) {
    if(pointToDraw == null){ // it isn't found the location yet.
         return super.draw(canvas, mapView, shadow); // do the default
    }        

   // else:
    super.draw(canvas, mapView, shadow);

                   // NPE happening here
        mScreenPoints = mapView.getProjection().toPixels(pointToDraw, mScreenPoints);

        int totalCircle=4;
        int radius=40;
        int centerimagesize=35;

        for (int i = 1; i <= totalCircle; i ++) { 
            canvas.drawCircle(mScreenPoints.x,mScreenPoints.y, i*radius, mCirclePaint); 
        } 

        canvas.drawBitmap(mBitmap, (mScreenPoints.x-(centerimagesize/2)),(mScreenPoints.y-(centerimagesize/2)), null);
        super.draw(canvas,mapView,shadow);

        return true;
    }