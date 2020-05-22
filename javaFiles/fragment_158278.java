String macStr = "";
        for (int i = 0; i < mac.length; i++) {
            System.out.format("%02X%s",mac[i], (i < mac.length - 1) ? "-" : "" +"\n");
            macStr += String.format("%02X%s",mac[i], (i < mac.length - 1) ? "-" : "" +"\n");
        }
        System.out.println("macStr" + macStr);
        addressMap.put(address.getHostAddress(), macStr);