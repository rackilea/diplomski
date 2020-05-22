public ArrayList<InetAddress> getConnectedDevices(String YourPhoneIPAddress) {
        ArrayList<InetAddress> ret = new ArrayList<InetAddress>();

        LoopCurrentIP = 0;

        String IPAddress = "";
        String[] myIPArray = YourPhoneIPAddress.split("\\.");
        InetAddress currentPingAddr;


        for (int i = 0; i <= 255; i++) {
            try {

                // build the next IP address
                currentPingAddr = InetAddress.getByName(myIPArray[0] + "." +
                        myIPArray[1] + "." +
                        myIPArray[2] + "." +
                        Integer.toString(LoopCurrentIP));
                ad = currentPingAddr.toString();   /////////////////
                Log.d("MyApp",ad);                 //////////////

                // 50ms Timeout for the "ping"
                if (currentPingAddr.isReachable(50)) {

                    ret.add(currentPingAddr);
                    ad = currentPingAddr.toString();        /////////////////
                    Log.d("MyApp",ad);                     //////////////
                }
            } catch (UnknownHostException ex) {
            } catch (IOException ex) {
            }

            LoopCurrentIP++;
        }
        return ret;
    }