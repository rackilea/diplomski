public void test(Context context)
{
    WifiManager manager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
    WifiConfiguration wifiConf = ... /* Get Wifi configuration you want to update */

    if (wifiConf != null)
    {
        try
        {
            setStaticIpConfiguration(manager, wifiConf,
                InetAddress.getByName("10.0.0.1"), 24,
                InetAddress.getByName("10.0.0.2"),
                new InetAddress[] { InetAddress.getByName("10.0.0.3"), InetAddress.getByName("10.0.0.4") });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}