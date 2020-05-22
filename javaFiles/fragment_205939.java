try {
      InetAddress i = InetAddress.getByName(URLName);
    } catch (UnknownHostException e1) {
      e1.printStackTrace();
    }
// ... actually using URLName