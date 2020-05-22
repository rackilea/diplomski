public class InterceptionAgent {
  public static void premain(String arguments, 
                             Instrumentation instrumentation) {
    new AgentBuilder.Default()
      .rebase(isSubtypeOf(ProxiedPlayer.class))
      .transform(new AgentBuilder.Transformer() {
        @Override
        public DynamicType.Builder transform(DynamicType.Builder builder) {
          return builder.method(named("setPermission"))
                        .intercept(MethodDelegation.to(MyInterceptor.class)
                      .andThen(SuperMethodInvocation.INSTANCE));
        }
      }).installOn(instrumentation);
  }
}