Service service = EasyMock.createMock(Service.class);
service.applyInitialDump(entities);
EasyMock.expectLastCall().times(100);

processor.processInitialDump(entities)
EasyMock.verify(service);