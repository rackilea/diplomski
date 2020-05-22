public static void Main(string[] args)
{
    ctdl_User user = new ctdl_User();
    user.name = "Alice";
    Save<ctdl_User>(user);
    ctdl_User user2 = Load<ctdl_User>();
    Console.WriteLine(user2.name);

    ctdl_Device device = new ctdl_Device();
    device.type = "printer";
    Save<ctdl_Device>(device);
    ctdl_Device device2 = Load<ctdl_Device>();
    Console.WriteLine(device2.type);
}