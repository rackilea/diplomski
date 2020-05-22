public class SampleProducer : CoroutineProducer<Object>
{
    private WhileLoop<Object> loop;//our control structures become state!!
    public SampleProducer()
    {
        loop = new WhileLoop()
        {
            private int other_state;//our local variables become state of the control structure
            protected WhileState execute() 
            {
                //this implements a single iteration of the loop
                if(is_done) return WhileState.BREAK;
                //read input
                //parse input
                Object calcluated_value = ...;
                //update is_done, figure out if we want to continue
                setReturnValue(calculated_value);
                return WhileState.YIELD;
            }
        };
    }
    public Object Produce()
    {
        Object val = loop.loop();
        return val;
    }
    public boolean isDone()
    {
        //we are done when the loop has exited
        return loop.isDone();
    }
}