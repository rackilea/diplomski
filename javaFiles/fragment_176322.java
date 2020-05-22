@Test
@SuppressWarnings("unchecked")
public void withValue() {
    ArgumentCaptor<Optional<ZonedDateTime>> timeCaptor = ArgumentCaptor.forClass(Optional.class);
    AccountHandler accountHandler = mock(AccountHandler.class);

    Optional<ZonedDateTime> input = Optional.of(ZonedDateTime.now());
    accountHandler.processMessage(input);

    verify(accountHandler).processMessage(timeCaptor.capture());

    Optional<ZonedDateTime> optional = timeCaptor.getValue();
    assertTrue(optional.isPresent());
    assertNotNull(optional.get());
}

@Test
@SuppressWarnings("unchecked")
public void nullOptional() {
    ArgumentCaptor<Optional<ZonedDateTime>> timeCaptor = ArgumentCaptor.forClass(Optional.class);
    AccountHandler accountHandler = mock(AccountHandler.class);

    Optional<ZonedDateTime> input = null;
    accountHandler.processMessage(input);

    verify(accountHandler).processMessage(timeCaptor.capture());

    Optional<ZonedDateTime> optional = timeCaptor.getValue();
    assertNull(optional);
}