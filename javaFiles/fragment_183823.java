Class innerType = Whitebox.getInnerClassType(Final.class, "Inner");
Object innerTypeMock = PowerMock.createMock(innerType);
PowerMock.expectNew(innerType).andReturn(innerTypeMock);
PowerMock.expectPrivate(innerTypeMock, "method").andReturn(42);
PowerMock.replayAll();
System.out.println(""+new Final().callInnerClassMethod());