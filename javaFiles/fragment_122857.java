Iterator<LogEvent> toLogEvents(final Iterator<String> lineIterator) {
    return new Iterator<LogEvent>() {
        @Override
        public boolean hasNext() {
            return lineIterator.hasNext();
        }

        @Override
        public LogEvent next() {
            final LogEvent.Builder builder = LogEvent.builder();
            String line;
            while(lineIterator.hasNext() && !(line = lineIterator.next()).isEmpty()) {
                builder.appendLine(line);
            }
            return builder.build();
        }
    };
}