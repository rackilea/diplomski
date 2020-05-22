abstract class RuleHandler<T extends Rule>
{
  final Class<T> clazz;
  // as before
}

class HandlerDispatcher
{
  private final Map<Class<?>, RuleHandler<?>> handlers;
  void register(RuleHandler<?> handler)
  {
    handlers.put(handler.clazz, handler);
  }
  void doStuff(List<Rule> rules)
  {
    for(Rule rule : rules)
    {
      @SuppressWarnings("unchecked")
      RuleHandler<Rule> handler = (RuleHandler<Rule>) handlers.get(rule.getClass());
      handler.doStuff(rule);
    }
  }
}

class Test
{
  void main()
  {
    HandlerDispatcher hd = new HandlerDispatcher();
    hd.register(new ExampleRuleHandler());

    RuleHandler<?> handler = new ExampleRuleHandler();
    hd.register(handler);
  }
}