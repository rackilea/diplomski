public class ScriptDynamicScopeFactory extends ContextFactory {
    @Override
    protected Context makeContext() {
        ScriptContext ctx = new ScriptContext();
        ctx.setInstructionObserverThreshold(10000);
        return ctx;
    }

    @Override
    protected void observeInstructionCount(Context ctx, int instructionCount) {
      long currentTime = System.currentTimeMillis();
      long executionTime = (currentTime - ((ScriptContext) ctx).startTime());
      // do something if execution time is greater then your timeout
    }
}