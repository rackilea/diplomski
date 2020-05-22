android {
    defaultConfig {

        //Set BuildConfig.DEVELOPER_MACHINE_IP to the IP address of any interface.
        def ipList = getLocalIPv4()
        buildConfigField("String", "DEVELOPER_MACHINE_IP", ipList.empty ? '""' : '"' + ipList.get(0) + '"')
    }
}