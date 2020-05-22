USM usm = new USM(SecurityProtocols.getInstance(),  new OctetString(MPv3.createLocalEngineID()), 0);

SecurityModels.getInstance().addSecurityModel(usm);

//Add engine id while addinf user
snmp.getUSM().addUser(new OctetString(username), new OctetString("12345"),
                        new UsmUser(new OctetString(username), AuthSHA.ID, new OctetString(authpassphrase), PrivAES192.ID, new OctetString(privacypassphrase)));

//set the same engine to localEngineId
snmp.setLocalEngine(new OctetString("12345").getValue(),0,0);