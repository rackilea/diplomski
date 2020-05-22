if (isIPv6Supported()) { 
      o = InetAddress.loadImpl("Inet6AddressImpl"); 
  } 
  else { 
      o = InetAddress.loadImpl("Inet4AddressImpl"); } 
      return (InetAddressImpl)o; 
  }