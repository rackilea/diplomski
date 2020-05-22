private MyApplication app;
private EmailService email;

@BeforeEach
void setup() {
    email = mock(EmailService.class);
    when(email.sendEmail(any(), any())).thenReturn(true);
    app = new MyApplication(email);
}

@Test
void testProcessZeroLengthMessageOrPerson() {
    assertFalse(app.processMessages("", "Person"));
    assertFalse(app.processMessages("Message", "")):
    assertFalse(app.processMessages("", "")):
}

@Test
void testProcessMessage() {
    assertTrue(app.processMessage("Message", "Person"));
    verify(email).sendEmail("Message", "Person");
}