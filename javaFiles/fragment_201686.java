Enumeration<NetworkInterface> interfaces =
                    NetworkInterface.getNetworkInterfaces();
  while (interfaces.hasMoreElements()) {
    NetworkInterface i = interfaces.nextElement();
    if ( i.getHardwareAddress().... ) {
    }

  }