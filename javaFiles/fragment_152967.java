IJIAuthInfo authInfo = new JIDefaultAuthInfoImpl("remoteComputerIpAddress", "wmiUserName", "wmiUserPassword");
        IJIWinReg registry = null;
        try {
            registry = JIWinRegFactory.getSingleTon().getWinreg(authInfo, "remoteComputerIpAddress", true);
            JIPolicyHandle policyHandle = registry.winreg_OpenHKLM();
            JIPolicyHandle policyHandle2 = registry.winreg_OpenKey(policyHandle, "SOFTWARE\\wisemon",
                    IJIWinReg.KEY_ALL_ACCESS);
            // JIPolicyHandle policyHandle3 =
            // registry.winreg_OpenKey(policyHandle2,"wisemon",IJIWinReg.KEY_ALL_ACCESS);
            System.out.println("Printing first 1000 entries under HKEY_LOCAL_MACHINE\\BCD00000000...");
            for (int i = 0; i < 1; i++) {
                // String[] values = registry.winreg_EnumKey(policyHandle3,i);
                // Object[] values = registry.winreg_EnumValue(policyHandle3,i);
                Object[] values = registry.winreg_QueryValue(policyHandle2, "name", 100);
                Object[] values2 = registry.winreg_QueryValue(policyHandle2, "date", 100);
                System.out.println(new String((byte[]) values[1]));
                System.out.println(new String((byte[]) values2[1]));
            }
        } catch (UnknownHostException | JIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            System.out.println("Closing registry connection");
            registry.closeConnection();
        }