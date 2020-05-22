// The ThreadedListener means the network thread won't be blocked when waiting for RMI responses.
    client.addListener(new ThreadedListener(new Listener() {
        public void connected (final Connection connection) {
            TestObject test = ObjectSpace.getRemoteObject(connection, 42, TestObject.class);
            // Normal remote method call.
            assertEquals(43.21f, test.other());
            // Make a remote method call that returns another remote proxy object.
            OtherObject otherObject = test.getOtherObject();
            // Normal remote method call on the second object.
            assertEquals(12.34f, otherObject.value());
            // When a remote proxy object is sent, the other side recieves its actual remote object.
            connection.sendTCP(otherObject);
        }
    }));