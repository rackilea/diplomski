connection.setStatus(true,"ONLINE");

public void setStatus(boolean available, String status) throws XMPPException {
        Presence.Type type = available? Type.available: Type.unavailable;
        Presence presence = new Presence(type);
        presence.setStatus(status);
        connection.sendPacket(presence);
    }