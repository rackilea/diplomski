// In the handler for _ah/xmpp/presence/available
XMPPService xmppService = XMPPServiceFactory.getXMPPService();
Presence presence = xmppService.parsePresence(req);

// Split the XMPP address (e.g., user@gmail.com)
// from the resource (e.g., gmail.CD6EBC4A)
String from = presence.getFromJid().getId().split("/")[0];

// Mirror the contact's presence back to them
xmppService.sendPresence(from, PresenceType.AVAILABLE, presence.getPresenceShow(), presence.getStatus());