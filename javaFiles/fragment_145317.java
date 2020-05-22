@Immutable // See JSR 305
public final class Edge
{
    private final int minCardinality;
    // ...

    public static Builder newBuilder() { return new Builder(); }

    // Edge has no public constructor anymore, only this one:
    private Edge(final Builder builder)
    {
        minCardinality = builder.minCardinality;
        // etc
    }

    @NotThreadSafe // See JSR 305
    public static final class Builder
    {
        private int minCardinality;
        // ...

        private Builder() {}

        public Builder withMinCardinality(final int minCardinality)
        {
            this.minCardinality = minCardinality;
            return this;
        }
        // etc

        public Edge build()
        {
            // checks here
            return new Edge(this);
        }
    }
}