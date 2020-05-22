public static void CreateAd(Activity act, String publisherID, int horz, int vert, int offsetX, int offsetY)
{       
    Looper.prepare();

    Intent myIntent = new Intent(act, ChartboostActivity.class);
    act.startActivity(myIntent);
}