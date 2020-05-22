socket.on("getbrowser1f", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.d(TAG, "object.event");
                socket.emit("doit2","msg2");
            }
        });