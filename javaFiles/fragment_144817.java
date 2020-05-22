// Java
public class JavaClass
{
    public static class Builder
    {
        public Builder(String serverUri)
        {
        }

        public Builder multiThreaded(boolean isMultiThreaded)
        {
            return this;
        }

        public Builder discoveryEnabled(boolean isDiscoveryEnabled)
        {
            return this;
        }

        public String build()
        {
            return "BUILD";
        }
    }
}