StatefulSFTPClient client;          
            if(ssh.isConnected()){
                if(ssh.isAuthenticated()){
                    client = new StatefulSFTPClient(new SFTPEngine(ssh).init());
                } else {
                    throw new IllegalStateException("Not authenticated");
                }
            } else {
                throw new IllegalStateException("Not connected");
            }