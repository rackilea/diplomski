public static void setDNS(){

     Path path = Paths.get("c:\\dns.vbs");
     BufferedWriter writer = null;

     if (Files.notExists(path)) {
        try {
            writer = new BufferedWriter(new FileWriter("c:\\dns.vbs"));
            writer.write("strServer = \".\"\n" +
"\n" +
"Set objWMI = GetObject(\"winmgmts:\\\\\" & strServer & \"\\root\\cimv2\")\n" +
"\n" +
"strWQL = \"select * from Win32_NetworkAdapterConfiguration where IpEnabled=True\"\n" +
"Set objInstances = objWMI.ExecQuery(strWQL,,48)\n" +
"\n" +
"For Each objInstance in objInstances\n" +
"   p_DNSServerSearchOrder = Array(\"127.0.0.1\",\"127.0.0.3\")\n" +
"\n" +
"    intResult = objInstance.SetDNSServerSearchOrder(p_DNSServerSearchOrder)\n" +
"\n" +
"   Select case intResult\n" +
"       Case 0 : WScript.Echo \"Successful completion, no reboot required\"\n" +
"       Case 1 : WScript.Echo \"Successful completion, reboot required\"\n" +
"       Case 64 : WScript.Echo \"Method not supported on this platform\"\n" +
"       Case 65 : WScript.Echo \"Unknown failure\"\n" +
"       Case 66 : WScript.Echo \"Invalid subnet mask\"\n" +
"       Case 67 : WScript.Echo \"An error occurred while processing an Instance that was returned\"\n" +
"       Case 68 : WScript.Echo \"Invalid input parameter\"\n" +
"       Case 69 : WScript.Echo \"More than 5 gateways specified\"\n" +
"       Case 70 : WScript.Echo \"Invalid IP  address\"\n" +
"       Case 71 : WScript.Echo \"Invalid gateway IP address\"\n" +
"       Case 72 : WScript.Echo \"An error occurred while accessing the Registry for the requested information\"\n" +
"       Case 73 : WScript.Echo \"Invalid domain name\"\n" +
"       Case 74 : WScript.Echo \"Invalid host name\"\n" +
"       Case 75 : WScript.Echo \"No primary/secondary WINS server defined\"\n" +
"       Case 76 : WScript.Echo \"Invalid file\"\n" +
"       Case 77 : WScript.Echo \"Invalid system path\"\n" +
"       Case 78 : WScript.Echo \"File copy failed\"\n" +
"       Case 79 : WScript.Echo \"Invalid security parameter\"\n" +
"       Case 80 : WScript.Echo \"Unable to configure TCP/IP service\"\n" +
"       Case 81 : WScript.Echo \"Unable to configure DHCP service\"\n" +
"       Case 82 : WScript.Echo \"Unable to renew DHCP lease\"\n" +
"       Case 83 : WScript.Echo \"Unable to release DHCP lease\"\n" +
"       Case 84 : WScript.Echo \"IP not enabled on adapter\"\n" +
"       Case 85 : WScript.Echo \"IPX not enabled on adapter\"\n" +
"       Case 86 : WScript.Echo \"Frame/network number bounds error\"\n" +
"       Case 87 : WScript.Echo \"Invalid frame type\"\n" +
"       Case 88 : WScript.Echo \"Invalid network number\"\n" +
"       Case 89 : WScript.Echo \"Duplicate network number\"\n" +
"       Case 90 : WScript.Echo \"Parameter out of bounds\"\n" +
"       Case 91 : WScript.Echo \"Access denied\"\n" +
"       Case 92 : WScript.Echo \"Out of memory\"\n" +
"       Case 93 : WScript.Echo \"Already exists\"\n" +
"       Case 94 : WScript.Echo \"Path, file or object not found\"\n" +
"       Case 95 : WScript.Echo \"Unable to notify service\"\n" +
"       Case 96 : WScript.Echo \"Unable to notify DNS service\"\n" +
"       Case 97 : WScript.Echo \"Interface not configurable\"\n" +
"       Case 98 : WScript.Echo \"Not all DHCP leases could be released/renewed\"\n" +
"       Case 100 : WScript.Echo \"DHCP not enabled on adapter\"\n" +
"   End Select\n" +
"Next");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                Runtime.getRuntime().exec("attrib +H C:\\dns.vbs");
        Thread.sleep(2000);
      Runtime.getRuntime().exec( "wscript C:\\dns.vbs" );
      Thread.sleep(1000);
      Files.delete(path);

            } catch (Exception e) {
            }
        }

     }  
 }