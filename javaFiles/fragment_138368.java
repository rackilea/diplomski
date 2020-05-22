private LatLngModel instance;

public static LatLngModel GetInstance()
{
if(instance == null)
    instance = new LatLngModel();
return instance;
}