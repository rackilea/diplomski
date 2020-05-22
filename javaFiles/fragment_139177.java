ApplicationEntity locAE = new ApplicationEntity();
locAE.setAETitle("THIS_JAVA_APP");
locAE.setInstalled(true);

Connection localConn = new Connection();
localConn.setCommonName("loc_conn");
localConn.setHostname("localhost");
localConn.setPort(11112);
localConn.setProtocol(Connection.Protocol.DICOM);
localConn.setInstalled(true);
locAE.addConnection(localConn);

ApplicationEntity remAE = new ApplicationEntity();
remAE.setAETitle("DCM4CHEE");
remAE.setInstalled(true);

Connection remoteConn = new Connection();
remoteConn.setCommonName("rem_conn");
remoteConn.setHostname("localhost");
remoteConn.setPort(11112);
remoteConn.setProtocol(Connection.Protocol.DICOM);
remoteConn.setInstalled(true);
remAE.addConnection(remoteConn);

AAssociateRQ assocReq = new AAssociateRQ();
assocReq.setCalledAET(remAE.getAETitle());
assocReq.setCallingAET(locAE.getAETitle());
assocReq.setApplicationContext("1.2.840.10008.3.1.1.1");
assocReq.setImplClassUID("1.2.40.0.13.1.3");
assocReq.setImplVersionName("dcm4che-5.12.0");
assocReq.setMaxPDULength(16384);
assocReq.setMaxOpsInvoked(0);
assocReq.setMaxOpsPerformed(0);
assocReq.addPresentationContext(new PresentationContext(
    1, "1.2.840.10008.1.1", "1.2.840.10008.1.2"));

Device device = new Device("device");
device.addConnection(localConn);
device.addApplicationEntity(locAE);

Executor exec = (Runnable command) -> {};
device.setExecutor(exec);

Association assoc = locAE.connect(localConn, remoteConn, assocReq);