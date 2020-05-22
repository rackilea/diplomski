public enum SourceStatusComparisonType
{
    CONTEXT_KEY
    {
        @Override
        public boolean compareKeys(SourceStatus source, ApplicationStatus status)
        {
            return source.getContextKey() == status.getSourceContextId();
        }
    },
    DATE
    {
        @Override
        public boolean compareKeys(SourceStatus source, ApplicationStatus status)
        {
            return source.getCobDate().equals(status.getCobDate());
        }
    },
    DEFAULT;

    public boolean compareKeys(SourceStatus source,
            ApplicationStatus status) {
//        return somedefaultvalue;
    }
}