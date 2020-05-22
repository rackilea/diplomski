private ServerEvent filterEvents(final Class<?> c) {
    return argThat(new ArgumentMatcher<ServerEvent>() {
        @Override
        public boolean matches(Object argument) {
            return c.isInstance(argument);
        }
    });