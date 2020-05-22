@Test
public void testLogout() {
    Session.current().put(SESSION_KEY_USERID, "1");
    Response.current().setCookie(COOKIE_NAME, "A value");
    assertNotNull(Session.current().get(SESSION_KEY_USERID));
    assertTrue(Response.current().cookies.containsKey(COOKIE_NAME));
    Cookie cookie = Response.current().cookies.get(COOKIE_NAME);
    assertFalse(Integer.valueOf(0).equals(cookie.maxAge));
    assertEquals("A value", cookie.value);
    service.logout();
    assertNull(Session.current().get(SESSION_KEY_USERID));
    cookie = Response.current().cookies.get(COOKIE_NAME);
    assertTrue(Integer.valueOf(0).equals(cookie.maxAge));
    assertEquals("", cookie.value);
}