List<DiscoveredDevice> devices = new ArrayList<DiscoveredDevice>();
        for (int i = 0; i < 256; i++)
        {
            // this hardcoded ip will be variable from the wifi's ip
            String ip = "xx.xx.x." + i;
            // this socket may be forever hard coded unless i find a better way. :(
            devices.add(new DiscoveredDevice(32999, ip, "", ""));
        }