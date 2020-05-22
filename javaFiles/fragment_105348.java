public final class ModelInput {

    private long userid;
    private long clientid;
    private long timeout = 500L;
    private Preference pref;
    private boolean debug;
    private Map<String, String> parameterMap;

    public ModelInput(Builder builder) {
        this.userid = builder.userId;
        this.clientid = builder.clientId;
        this.pref = builder.preference;
        this.parameterMap = builder.parameterMap;
        this.timeout = builder.timeout;
        this.debug = builder.debug;
    }

    public static class Builder {
        private long userId;
        private long clientId;
        private Preference preference;
        private boolean debug;
        private Map<String, String> parameterMap;

        public Builder(long userId, long clientId, Map<String, String> parameterMap) {
            this.userId = userId;
            this.clientId = clientId;
            this.parameterMap = parameterMap;
        }

        public Builder preference(Preference preference) {
            this.preference = preference;
            return this;
        }

        public Builder debug(boolean debug) {
            this.debug = debug;
            return this;
        }

        public Builder timeout(long timeout) {
            this.timeout = timeout;
            return this;
        }

        ...

        public ModelInput build() {
            return ModelInput(this);
        }
    }

    // ModelInput getters / setters
}