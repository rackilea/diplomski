@Test
public void testAddEventWithWebAuthenticationDetails() {
    HttpSession session = new MockHttpSession(null, "test-session-id");
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setSession(session);
    request.setRemoteAddr("1.2.3.4");
    WebAuthenticationDetails details = new WebAuthenticationDetails(request);
    Map<String, Object> data = new HashMap<>();
    data.put("test-key", details);
    AuditEvent event = new AuditEvent("test-user", "test-type", data);
    customAuditEventRepository.add(event);
    List<PersistentAuditEvent> persistentAuditEvents = persistenceAuditEventRepository.findAll();
    assertThat(persistentAuditEvents).hasSize(1);
    PersistentAuditEvent persistentAuditEvent = persistentAuditEvents.get(0);
    assertThat(persistentAuditEvent.getData().get("remoteAddress")).isEqualTo("1.2.3.4");
    assertThat(persistentAuditEvent.getData().get("sessionId")).isEqualTo("test-session-id");
}