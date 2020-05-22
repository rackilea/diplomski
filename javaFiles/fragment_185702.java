public abstract class ParentValidator
{
    public final void validate() {
        //some code
        subValidate();
    }
    protected abstract void subValidate() {}
}