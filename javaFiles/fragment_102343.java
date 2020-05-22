public static class Inner1
{
    public static class Inner2
    {
        public static class Inner3
        {
            public void demo() {
                Class<Inner2> c = Inner2.class; // This is allowed
            }
        }
    }
}