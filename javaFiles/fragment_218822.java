public class MyPositionOverlay extends Overlay {

    Location location;
    private final int mRadius=5;

    @Override
    public void draw(Canvas canvas,MapView mapView,boolean shadow){

        Projection projection=mapView.getProjection();

        if(shadow==false){
            Double latitude=location.getLatitude()*1E6;
            Double longitude=location.getLongitude()*1E6;

            GeoPoint geoPoint;
             geoPoint=new GeoPoint(latitude.intValue(),longitude.intValue());

             Point point=new Point();
             projection.toPixels(geoPoint, point);

             RectF oval=new RectF(point.x - mRadius,point.y - mRadius,point.x + mRadius,point.y + mRadius);

             Paint paint=new Paint();
             paint.setARGB(250, 255, 255, 255);

             paint.setAntiAlias(true);
             paint.setFakeBoldText(true);

             Paint backPaint=new Paint();
             backPaint.setARGB(175, 50, 50, 50);
             backPaint.setAntiAlias(true);

             RectF backRect=new RectF(point.x + 2 + mRadius, point.y - 3*mRadius,point.x + 65, point.y + mRadius);

             canvas.drawOval(oval, paint);
             canvas.drawRoundRect(backRect, 5, 5, backPaint);
             canvas.drawText("Here I Am", point.x + 2*mRadius, point.y, paint);
        }
        super.draw(canvas, mapView, shadow);


        }

    @Override
    public boolean onTap(GeoPoint point,MapView mapView){


            return false;
            }


public Location getLocation(){

    return location;

}
public void setLocation(Location location){
    this.location=location;
}
}