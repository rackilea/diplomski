enum WhileState {BREAK, CONTINUE, YIELD}
abstract class WhileLoop<T>
{
    private boolean is_done;
    public boolean isDone() { return is_done;}
    private T rval;
    public T getReturnValue() {return rval;} 
    protected void setReturnValue(T val)
    {
        rval = val;
    }


    public T loop()
    {
        while(true)
        {
            WhileState state = execute();
            if(state == WhileState.YIELD)
                return getReturnValue();
            else if(state == WhileState.BREAK)
                    {
                       is_done = true;
                return null;
                    }
        }
    }
    protected abstract WhileState execute();
}