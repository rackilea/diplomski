//Your initialization
        HashMap settinglist=new HashMap();
        settinglist.put("a","abc");
        settinglist.put("b","def");
        settinglist.put("c","hij");
        settinglist.put("d","klm");
        settinglist.put("e", "nop");
        SettingsObjectSerializer.serializeObject(getApplicationContext(),settinglist);

        //Change the value linked to key "b" to "NEWVALUE"
        HashMap settings = SettingsObjectSerializer.getSerializedObject(getApplicationContext());
        settings.put("b", "NEWVALUE");
        SettingsObjectSerializer.serializeObject(getApplicationContext(),settings);