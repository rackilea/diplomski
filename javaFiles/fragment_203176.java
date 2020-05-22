public static void setFakePassenger(Player spectator, Entity target) {
    EntityPlayer nmsSpectator = ((CraftPlayer) spectator).getHandle();
    PacketPlayOutAttachEntity attachPacket = new PacketPlayOutAttachEntity(0, nmsSpectator, ((CraftEntity) target).getHandle()); // The packet that tells a client to attach to an entity
    nmsSpectator.playerConnection.sendPacket(attachPacket); // Send packet to client
    // spectators is a HashMap<UUID, Entity> so that we can keep track of which players are spectating which entities
    spectators.put(spectator.getUniqueId(), target);
}