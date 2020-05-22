@SuppressWarnings("unchecked")
private static void setStaticIpConfiguration(WifiManager manager, WifiConfiguration config, InetAddress ipAddress, int prefixLength, InetAddress gateway, InetAddress[] dns) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException
{
    // First set up IpAssignment to STATIC.
    Object ipAssignment = getEnumValue("android.net.IpConfiguration$IpAssignment", "STATIC");
    callMethod(config, "setIpAssignment", new String[] { "android.net.IpConfiguration$IpAssignment" }, new Object[] { ipAssignment });

    // Then set properties in StaticIpConfiguration.
    Object staticIpConfig = newInstance("android.net.StaticIpConfiguration");
    Object linkAddress = newInstance("android.net.LinkAddress", new Class<?>[] { InetAddress.class, int.class }, new Object[] { ipAddress, prefixLength });

    setField(staticIpConfig, "ipAddress", linkAddress);
    setField(staticIpConfig, "gateway", gateway);
    getField(staticIpConfig, "dnsServers", ArrayList.class).clear();
    for (int i = 0; i < dns.length; i++)
        getField(staticIpConfig, "dnsServers", ArrayList.class).add(dns[i]);

    callMethod(config, "setStaticIpConfiguration", new String[] { "android.net.StaticIpConfiguration" }, new Object[] { staticIpConfig });
    manager.updateNetwork(config);
    manager.saveConfiguration();
}