public static String getIpAddress() 
    { 
    URL myIP;
    try {
        myIP = new URL("http://api.externalip.net/ip/");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(myIP.openStream())
                );
        return in.readLine();
    } catch (Exception e) 
    {
        try 
        {
            myIP = new URL("http://myip.dnsomatic.com/");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(myIP.openStream())
                    );
            return in.readLine();
        } catch (Exception e1) 
        {
            try {
                myIP = new URL("http://icanhazip.com/");

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(myIP.openStream())
                        );
                return in.readLine();
            } catch (Exception e2) {
                e2.printStackTrace(); 
            }
        }
    }

return null;
}