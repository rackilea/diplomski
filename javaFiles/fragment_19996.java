sSearchString = "emulator.Android.driver.";
    mDriverProperties = new HashMap<String, String>();
    Set<String> sKeys = pTestProperties.stringPropertyNames();
    for (String sKey : sKeys)
    {
        if (sKey.startsWith(sSearchString))
        {
            sKey = sKey.substring(sKey.lastIndexOf(".") + 1);
            mDriverProperties.put(sKey, pTestProperties.getProperty(sSearchString + sKey));
        }
    }