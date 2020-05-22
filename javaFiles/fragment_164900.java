public class Logger extends DefaultExecuteListener {
    @Override
    public void executeStart(ExecuteContext ctx) {
        MyUtils.writeToFile(ctx.sql());
    }
}