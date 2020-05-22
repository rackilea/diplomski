public enum State
{
    State1
    {
        @Override
        public State process()
        {
            return State2;
        }
    },
    State2,
    State3;

    public State process()
    {
        return this;
    }
}