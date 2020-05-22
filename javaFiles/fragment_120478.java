XmppHandler xmpp = new XmppHandler(XMPPuser, XMPPpassword, XMPPaddress, XMPPdomain, XMPPport);

XMPPmessageListener msglistener = new XMPPmessageListener() {

                @Override
                public void readMsg(String senderJID, String msg) {
                    String asw=xmlHandler.processMsg(msg,senderJID);

                }
            };
            xmpp.addMsgListener(msglistener);