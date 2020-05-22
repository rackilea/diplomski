import static org.mockito.Mockito.*

...

@Test
public void test(){
    // Given
    Authentication authentication = mock(Authentication.class);
    when(authentication.isAuthenticatedFor(eq(name),eq(permission)).thenReturn(true);

    // When
    permissionEval.hasPermission(authentication,name, permission);

    // Then
    // Do you asserts/verify
}