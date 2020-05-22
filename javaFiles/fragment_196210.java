private final String STR_OS_NAME_REGISTRY_QUERY = "reg query \"HKLM\\Software\\Microsoft\\Windows NT\\CurrentVersion\" /v \"ProductName\"";     

    // Get OS name
        objProcessName = Runtime.getRuntime().exec(STR_OS_NAME_REGISTRY_QUERY); 
        objProcessName.waitFor(); 
        objBufferReader = new BufferedReader(new InputStreamReader(objProcessName.getInputStream())); 
        lstJavaInfo = new ArrayList<>();

        while ((sLine = objBufferReader.readLine()) != null)
        {
            lstJavaInfo.add(sLine);
        }
        objProcessName.waitFor();

        if(lstJavaInfo.size() < 3)
        {
            return "-";
        }

        String[] sarr = lstJavaInfo.get(2).split("\\s+");
        for(int nIndex = 3 ; nIndex < sarr.length ; nIndex++)
        {
            sOSArchitecture = sOSArchitecture + sarr[nIndex] + " ";
        }