Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
            for (; n.hasMoreElements();)
            {
                    NetworkInterface e = n.nextElement();
                    System.out.println("Interface: " + e.getName());
                    Enumeration<InetAddress> a = e.getInetAddresses();
                    for (; a.hasMoreElements();)
                    {
                            InetAddress addr = a.nextElement();
                            System.out.println("  " + addr.getHostAddress());
                    }
            }