// This works both in tethering and when connected to an Access Point

    Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

    while (interfaces.hasMoreElements()) 
    {
        NetworkInterface networkInterface = interfaces.nextElement();

        if (networkInterface.isLoopback())
            continue; // Don't want to broadcast to the loopback interface

        for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) 
        {
                InetAddress broadcast = interfaceAddress.getBroadcast();

                // InetAddress ip = interfaceAddress.getAddress();                  
                // interfaceAddress.getNetworkPrefixLength() is another way to express subnet mask

                // Android seems smart enough to set to null broadcast to
                //  the external mobile network. It makes sense since Android
                //  silently drop UDP broadcasts involving external mobile network.
                if (broadcast == null)
                    continue;

                ... // Use the broadcast                
        }
    }