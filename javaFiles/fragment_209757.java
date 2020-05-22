while( !(ThreadPool.isStopped) ) {
            Socket client_socket = null;
            try {
                client_socket = serversocket.accept();

            } catch(SocketException se) {
                log.info(new Date() + " WEBSERVER STOPPED");
            }

            if(ThreadPool.isStopped) break;
            ThreadPool.threads.execute(new Worker(client_socket));          
     }