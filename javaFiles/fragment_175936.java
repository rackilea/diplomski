@Nullable
public String getTetheredGatewayIp() {
    NetworkInterface tetheredNic = getTetheredNetworkInterface();
    try {
        Class<?> systemPropertiesClass = Class.forName("android.os.SystemProperties");
        return (String) systemPropertiesClass
                .getMethod("get", String.class)
                .invoke(systemPropertiesClass, "dhcp." + tetheredNic.getName() + ".gateway");
    } catch (Exception ignore) {}
    return null;
}

// Find the NetworkInterface of any 'rndis' NIC:
@Nullable
private NetworkInterface getTetheredNetworkInterface() {
    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
    while (networkInterfaces.hasMoreElements()) {
        NetworkInterface nic = networkInterfaces.nextElement();
        if (nic.isUp() && !nic.isLoopback() && nic.getName().contains("rndis")) {
            return nic;
        }
    }
    return null;
}