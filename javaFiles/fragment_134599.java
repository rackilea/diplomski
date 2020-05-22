private Emitter.Listener onTransport = new Emitter.Listener() {
    @Override
    public void call(Object... args) {

        Transport transport = (Transport)args[0];
        transport.on(Transport.EVENT_REQUEST_HEADERS, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                @SuppressWarnings("unchecked")
                Map<String, List<String>> headers = (Map<String, List<String>>) args[0];
                String bearer = "bearer " + session.token;
                headers.put("Authorization", Arrays.asList(bearer));
            }
        }).on(Transport.EVENT_RESPONSE_HEADERS, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
            }
        });
    }
};