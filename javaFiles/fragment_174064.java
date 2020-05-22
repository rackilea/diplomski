public class MyLayout extends LayoutBase<ILoggingEvent> {
    public String doLayout(ILoggingEvent event) {
        if ("foo".equals(MDC.get("method"))) {
            return "a custom message for method `foo`\n";
        } else {
            return "a default message from my own layout\n";
        }
    }
}