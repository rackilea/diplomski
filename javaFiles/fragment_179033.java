@Test
public void testLogout() {

    // mock all static methods of FacesContext
    PowerMock.mockStatic(FacesContext.class);

    FacesContext context = EasyMock.createMock(FacesContext.class);
    ExternalContext ext = EasyMock.createMock(ExternalContext.class);

    EasyMock.expect(FacesContext.getCurrentInstance()).andReturn(context);
    EasyMock.expect(context.getExternalContext()).andReturn(ext);

    ext.invalidateSession();
    // expect the call to the invalidateSession() method
    EasyMock.expectLastCall();
    context.release();

    // replay the class (not the instance)
    PowerMock.replay(FacesContext.class);
    EasyMock.replay(context);
    EasyMock.replay(ext);

    String userName = "testUserName";
    LoginForm loginForm = new LoginForm();
    loginForm.setUserName(userName);

    String expected = "/authentication/login.xhtml?faces-redirect=true";
    String actual = loginForm.logout();
    context.release();

    Assert.assertEquals(expected, actual);

    // verify the class (not the instance)
    PowerMock.verify(FacesContext.class);
    EasyMock.verify(context);
    EasyMock.verify(ext);
}