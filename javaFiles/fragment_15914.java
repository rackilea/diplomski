public class SecurityAdvice {
    @Advice.OnMethodEnter
    private static void enter(@Advice.AllArguments Object[] args) {
        //...
    }

    @Advice.OnMethodExit
    private static void exit(@Advice.Return(typing = Typing.DYNAMIC) Object value) {
       //...
    }
}