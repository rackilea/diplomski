if (connectTimeout >= 0) {
            s.connect(new InetSocketAddress(server, port), connectTimeout);
        } else {
            if (defaultConnectTimeout > 0) {
                s.connect(new InetSocketAddress(server, port), defaultConnectTimeout);
            } else {
                s.connect(new InetSocketAddress(server, port));
            }   
        }