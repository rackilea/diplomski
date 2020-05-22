String hostName = request.getRemoteHost();
                   try {
                           if (hostName.equals(request.getRemoteAddr())) {
                                   InetAddress addr = InetAddress.getByName(request.getRemoteAddr());
                                   hostName = addr.getHostName();
                           }

                           if (InetAddress.getLocalHost().getHostAddress().equals(request.getRemoteAddr())) {
                                   hostName = "Local Host";
                           }

                   }
                   catch (UnknownHostException e) {
                           e.printStackTrace();
                   }