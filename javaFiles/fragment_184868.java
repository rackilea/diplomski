Memoize0<String> configProvider = new Memoize0<String>() {
        @Override
        public String calc() {
            return fetchConfigFromVerySlowDatabase();
        }
    };
    final String config = configProvider.get();

    Memoize1<Long, String> usernameProvider = new Memoize1<Long, String>() {
        @Override
        public String calc(Long id) {
            return fetchUsernameFromVerySlowDatabase(id);
        }
    };
    final String username = usernameProvider.get(123L);