public class fsmBot
{
    public String message;

    public enum BotStates
    {
        greeting
        {
            @Override
            public void message(fsmBot bot)
            {
                bot.message = "Hi";
            }

            @Override
            public String nextState()
            {
                String nxtState = state1.name();
                return nxtState;
            }
        },
        state1
        {
            @Override
            public void message(fsmBot bot)
            {
                bot.message = "How are you?";
            }

            @Override
            public String nextState()
            {
                String nxtState = state1.name();
                return nxtState;
            }
        };

        public abstract void message(fsmBot bot);
        public abstract String nextState();
    }
}