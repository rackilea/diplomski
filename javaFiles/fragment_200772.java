boolean match = FluentIterable.from(words).anyMatch(
    new Predicate<String>() {
        @Override
        public boolean apply(@Nullable final String w) {
            return p.matcher(w).matches();
        }
    }
);