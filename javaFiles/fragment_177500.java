public static void connectSocket(onSocketConnectionListener listener) {
    if (server == null) {
        server = new AsyncServer();
    }
    if (server.isRunning()) {
        if (listener != null)
            listener.connected(currentSocket);
        return;
    }
    ConnectCallback socketCallBack = new ConnectCallback() {
        @Override
        public void onConnectCompleted(Exception ex, AsyncSocket socket) {
            isConnecting = false;
            if (ex != null) {
                server.stop();
                sessionReloaded = false;
                Utils.Log("Exception = " + ex.getCause() + " , Server Running State = " + server.isRunning(), API.class);
                A.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                connectSocket(null);
                            }
                        }, 3000);
                    }
                });
                return;
            }
            Utils.Log("Server Running State = " + server.isRunning(), API.class);
            isConnected = true;
            currentSocket = socket;
            triggerConnections();
            socket.setDataCallback(new DataCallback() {
                @Override
                public void onDataAvailable(DataEmitter emitter, ByteBufferList bb) {
                    byte[] bytes = bb.getAllByteArray();
                    String[] content = Utils.splitJson(new String(bytes));
                    for (int i = 0; i < content.length; i++) {
                        Utils.Log("SocketDataReceived = " + content[i], API.class);
                        handleData(content[i]);
                    }
                    bb.recycle();
                }
            });
            socket.setClosedCallback(new CompletedCallback() {
                @Override
                public void onCompleted(Exception ex) {
                    if (ex != null) {
                        Utils.Log("Closed CallBack With Exception = " + ex.getCause(), API.class);
                    } else {
                        Utils.Log("Closed CallBack", API.class);
                    }
                    sessionReloaded = false;
                    isConnected = false;
                    server.stop();
                    triggerDisconnections();
                    A.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            new android.os.Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    connectSocket(new onSocketConnectionListener() {
                                        @Override
                                        public void connected(AsyncSocket socket) {
                                        }
                                    });
                                    Utils.Log("Closed CallBack", API.class);
                                }
                            }, 3000);
                        }
                    });
                }
            });
            socket.setEndCallback(new CompletedCallback() {
                @Override
                public void onCompleted(Exception ex) {
                    if (ex != null) {
                        Utils.Log("End CallBack With Exception = " + ex.getCause(), API.class);
                    } else {
                        Utils.Log("End CallBack", API.class);
                    }
                    sessionReloaded = false;
                    isConnected = false;
                    server.stop();

                }
            });
            socket.setWriteableCallback(new WritableCallback() {
                @Override
                public void onWriteable() {
                    Utils.Log("Write CallBack", API.class);
                }
            });

            User user = MDatabase.getUser();
            String session = MDatabase.getSession();
            if (sessionNeedsReload()) {
                reloadSession(user.mobile, session);
            } else {
                doPendingRequests();
            }
        }
    };

    synchronized (isConnecting) {
        if (!isConnecting) {
            isConnecting = true;
            Utils.Log("Socket Connecting ...", API.class);
            server.connectSocket(IP, PORT, socketCallBack);
        }
    }
}