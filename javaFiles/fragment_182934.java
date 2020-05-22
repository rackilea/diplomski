try  {
        System.out.println("sendMessageToRemoteGovernor :: "+message.getJson());
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        session = container.connectToServer(XYZ.class, new URI("ws://localhost:8080/xyz/xyz"));
        session.getBasicRemote().sendObject(message);
    }
    catch (Exception e) {
        e.printStackTrace();
    }