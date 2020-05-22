public static InetAddress addrFromStr (String addr)
{
    InetAddress ia = null;
    SubnetUtils su = new SubnetUtils (addr + "/8");

    try
    {
        ia = InetAddress.getByName (su.getInfo().getAddress());
    }
    catch (UnknownHostException e)
    { }

    return ia;
}