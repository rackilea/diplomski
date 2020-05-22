public GPSLocation(Context context)
{
    this.mContext = context;
    location = new Location("Bosch");
    getLocation();
}