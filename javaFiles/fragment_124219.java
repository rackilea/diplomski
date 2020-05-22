import static org.easymock.classextension.EasyMock.*;

File testDir = createMock(File.class);
expect(testDir.lastModified()).andReturn(10L);
// more expectations
replay(testDir);
// create a FileMonitor watching testDir
// run the method which gets invoked by the trigger     
verify(testDir);