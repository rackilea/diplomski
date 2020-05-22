class LogEvent {

    static Builder builder() {
        return new Builder();
    }

    static class Builder {
        Builder appendLine(final String line) {
            //do stuff
            return this;
        }

        LogEvent build() {
            //validate?
            return new LogEvent();
        }
    }
}