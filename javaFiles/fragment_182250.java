public abstract class Parent
{
    protected static Data createData(String d1, ...) {
        return new Data(d1, ...);
    }

    public static class Data
    {
        public final String data1
        ...

        private Data(String d1, ...)
        {
            data1 = d1;
            ...
        }
    }

    public abstract Data getData();
}