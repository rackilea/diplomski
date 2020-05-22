public abstract class StageScene extends GameScene
{
    final public void initialize()
    {
        //your initialization
        subInitialize();
    }

    protected abstract void subInitialize();
}