@Override
protected void _prepareDataSocket_(final Socket socket) throws IOException {
    if(preferences.getBoolean("ftp.tls.session.requirereuse")) {
        if(socket instanceof SSLSocket) {
            // Control socket is SSL
            final SSLSession session = ((SSLSocket) _socket_).getSession();
            if(session.isValid()) {
                final SSLSessionContext context = session.getSessionContext();
                context.setSessionCacheSize(preferences.getInteger("ftp.ssl.session.cache.size"));
                try {
                    final Field sessionHostPortCache = context.getClass().getDeclaredField("sessionHostPortCache");
                    sessionHostPortCache.setAccessible(true);
                    final Object cache = sessionHostPortCache.get(context);
                    final Method method = cache.getClass().getDeclaredMethod("put", Object.class, Object.class);
                    method.setAccessible(true);
                    method.invoke(cache, String.format("%s:%s", socket.getInetAddress().getHostName(),
                            String.valueOf(socket.getPort())).toLowerCase(Locale.ROOT), session);
                    method.invoke(cache, String.format("%s:%s", socket.getInetAddress().getHostAddress(),
                            String.valueOf(socket.getPort())).toLowerCase(Locale.ROOT), session);
                }
                catch(NoSuchFieldException e) {
                    // Not running in expected JRE
                    log.warn("No field sessionHostPortCache in SSLSessionContext", e);
                }
                catch(Exception e) {
                    // Not running in expected JRE
                    log.warn(e.getMessage());
                }
            }
            else {
                log.warn(String.format("SSL session %s for socket %s is not rejoinable", session, socket));
            }
        }
    }
}