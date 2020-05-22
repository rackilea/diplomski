public  static List<String> getMBeanAppsStatus(String host, String port, 
                                          String container, String filter, 
                                          String usr, String pwd) {
    // A new List
    List<String> output = new ArrayList<String>();

    //A StringBuilder that will be used to build each ouput String
    StringBuilder sb = new StringBuilder();

    int mbeanAppsIdx = 0;
    int LVar = mbeanAppsIdx;
    try {
        Object[] connections = connectMethd(host, port, container, filter, usr, pwd);

        MBeanServerConnection serverConn = (MBeanServerConnection)connections[0];

        System.out.println("serverConn from array variable in getMBeanAppsStatus" + serverConn);

        /* retrieve mbean apps matching given filter */
        ObjectName mbeanDomainName = new ObjectName(filter);
        Set mbeanAppNames = serverConn.queryNames(mbeanDomainName, null);

        /* pattern to extract mbean application names */
        Pattern mbeanAppPat = Pattern.compile("name=", Pattern.CASE_INSENSITIVE);

        /* mbean application name */
        ObjectName mbeanApp = null;

        /* retrieve mbean apps count */
        Iterator i;
        for (i = mbeanAppNames.iterator(); i.hasNext(); ) {

            mbeanAppsIdx++;
            System.out.println("Populating MBean App #" + mbeanAppsIdx + "details...");

            /* retrieve mbean app name and status */
            mbeanApp = (ObjectName)i.next();

            String mbeanAppFQDN = mbeanApp.toString();
            String mbeanAppName = mbeanAppPat.split(mbeanAppFQDN)[1];
            Boolean mbeanAppRunning = Boolean.valueOf(serverConn.getAttribute(mbeanApp, "Running").toString());
            String mbeanAppStatus = "DISABLED";

            if (mbeanAppRunning.booleanValue())
                mbeanAppStatus = "ENABLED";

            // Construct the output using a string builder as
            //      mbeanAppName,mbeanAppFQDN,mbeanAppStatus
            sb.append(mbeanAppName);
            sb.append(",");
            sb.append(mbeanAppFQDN);
            sb.append(",");
            sb.append(mbeanAppStatus);

            // Store the current ouput in the List output
            output.add(sb.toString());

            // Empty string builder
            sb.setLength(0)

            System.out.println("getMBeanAppsStatus output " + 
                               "mbeanAppName " + mbeanAppName + 
                               " mbeanAppFQDN " + mbeanAppFQDN + 
                               " mbeanAppStatus : " + mbeanAppStatus);

        }

    } catch (MalformedObjectNameException e) {

        e.getStackTrace();
    } catch (InstanceNotFoundException e) {

        e.getStackTrace();
    } catch (AttributeNotFoundException e) {

        e.getStackTrace();
    } catch (ReflectionException e) {

        e.getStackTrace();
    } catch (MBeanException e) {
        e.getStackTrace();
    } catch (IOException ioe) {
        System.out.println(ioe);
    }

    System.out.println("getMBeanAppsStatus Output " + output);
    return output;
}