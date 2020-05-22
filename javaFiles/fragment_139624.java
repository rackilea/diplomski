boolean isMyDesiredIp = false;
try
{
    isMyDesiredIp = isThisMyIpAddress(InetAddress.getByName("192.168.220.25")); //"localhost" for localhost
}
catch(UnknownHostException unknownHost)
{
    unknownHost.printStackTrace();
}