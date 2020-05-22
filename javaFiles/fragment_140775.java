listItems.add(
                "Device: " + mConnectedDeviceName +
                        System.getProperty("line.separator") +
                        "Timestamp: " + currentDateandTime +
                        System.getProperty("line.separator") +
                        "Location: " + latitude + " (lat) / " + longitude + " (lon)" +
                        System.getProperty("line.separator") +
                        "Phone id: "  + telephonyManager.getDeviceId() +
                        System.getProperty("line.separator") +
                        "Valid:" + (passed ? "YES" : "NO") +
                        System.getProperty("line.separator") +
                        "Values: " + "T" + v1 + " / " + v2 +
                        System.getProperty("line.separator") +
                       // "=========================" +
                        System.getProperty("line.separator") );//9/11/17
        clickCounter++;//9/11/17
        adapter.notifyDataSetChanged();//9/11/17