@RunWith(PowerMockRunner.class)
public class SVNPluginTest {

  @Test
  @PrepareForTest(SVNPlugin.class)
  public void createGlobalUSerTest() throws Exception{
    PowerMock.mockStatic(SVNPlugin.class);
    SVNPlugin svnPlugin = PowerMock.createMock(SVNPlugin.class);

    EasyMock.expect(SVNPlugin.getInstance()).andStubReturn(svnPlugin);
    EasyMock.expect(svnPlugin.getSynProject("", "", "", "")).andReturn(true);

    PowerMock.replay(SVNPlugin.class,svnPlugin);

    SVNPlugin svnplugin = SVNPlugin.getInstance();
    boolean checkOutFlg = svnplugin.getSynProject("", "", "", "");
    assertTrue(checkOutFlg);

    PowerMock.verify(svnPlugin,SVNPlugin.class);
  }
}