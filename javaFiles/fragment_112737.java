String ip;

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            int position =0;
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                //This filters out the interfaces
                // filters out 127.0.0.1 and inactive interfaces
                if (iface.isLoopback() || !iface.isUp())
                    continue;

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    ip = addr.getHostAddress();
                    position++;

                    if (position == 0 ) {
                        System.out.println(iface.getDisplayName() + " " + ip);
                    }

                    else{
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }