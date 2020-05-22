public class MyAgent extends Agent
{
    @Override
    protected void setup()
    {
         addBehaviour( new InformBehaviour() );
    }
    private class InformBehaviour extends CyclicBehaviour
    {
        //dostuff
    }
}