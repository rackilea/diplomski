public class MyCustomLayout extends LayoutBase<ILoggingEvent> {
    private String mySimpleArg;
    private MyComplexArray myComplexArray;

    public void setMySimpleArg(String mySimpleArg) {
        this.mySimpleArg = mySimpleArg;
    }

    public void setMyComplexArray(MyComplexArray myComplexArray) {
        this.myComplexArray = myComplexArray;
    }

    public String doLayout(ILoggingEvent iLoggingEvent) {
        // generate log in my format and use mySimpleArg and myComplexArray
        return "...";
    }
}