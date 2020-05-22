public abstract class View<THIS extends View<THIS,PM>, PM extends Source>  {
    protected abstract THIS getThis();
    ...
        eventManager.setTarget(getThis());
        ...

public final class SomeView extends View<SomeView,SomeSource> {
    protected SomeView getThis() {
        return this;
    }
    ...