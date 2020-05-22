private void broadcastUpdate(Presence update) {
    if (update.getFrom() == null) {
        return;
    }
    if (localServer.isLocal(update.getFrom())) {
        // Do nothing if roster service is disabled
        if (!RosterManager.isRosterServiceEnabled()) {
            return;
        }
        // Local updates can simply run through the roster of the local user
        String name = update.getFrom().getNode();
        try {
            if (name != null && !"".equals(name)) {
                Roster roster = rosterManager.getRoster(name);
                roster.broadcastPresence(update);
            }
        }
        catch (UserNotFoundException e) {
            log.warn("Presence being sent from unknown user " + name, e);
        }
        catch (PacketException e) {
            log.error(LocaleUtils.getLocalizedString("admin.error"), e);
        }
    }
    else {
        // Foreign updates will do a reverse lookup of entries in rosters
        // on the server
        log.warn("Presence requested from server "
                + localServer.getServerInfo().getXMPPDomain()
                + " by unknown user: " + update.getFrom());
    }
}