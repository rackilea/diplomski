public static String getIpAddress() { 
            try {
                for (Enumeration en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                    NetworkInterface intf = en.nextElement();
                    for (Enumeration enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()&&inetAddress instanceof Inet4Address) {
                            String ipAddress=inetAddress.getHostAddress().toString();
                            Log.e("IP address",""+ipAddress);
                            return ipAddress;
                        }
                    }
                }
            } catch (SocketException ex) {
                Log.e("Socket exception in GetIP Address of Utilities", ex.toString());
            }
            return null; 
    }