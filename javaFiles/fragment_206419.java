@Test
public testLogout()
{
   //setup
   FacesContext context = Mockito.mock(FacesContext.class);
   ExternalContext externalContext = Mockito.mock(ExternalContext.class);
   FacesContext.setCurrentInstance(context);
   when(context.getExternalContext()).thenReturn(externalContext);
   //act
   bean.logout();
   //verify
   verify(externalContext).invalidateSession();
}