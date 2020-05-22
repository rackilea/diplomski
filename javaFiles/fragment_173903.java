public class A
    {
        public int allowedMethod() { ... }
        public int forbiddenMethod() { ... }
    }

    public class B
    {
        private A a;

        public int allowedMethod()
        {
            return a.allowedMethod();
        }
    }