class Gui {}

interface ComponentRenderer<T extends GuiComponent<T>> {
    public void draw(T component);
}

// T is the self-type. Subclasses will set it to their own type. In this way this class
// can refer to the type of its subclasses.
abstract class GuiComponent<T extends GuiComponent<T>> extends Gui {
    private ComponentRenderer<T> componentRenderer;

    public void draw() {
        this.componentRenderer.draw(thisSub());
    }

    public void setComponentRenderer(ComponentRenderer<T> r) {}

    // This method is needed for the superclass to be able to use 'this'
    // with a subclass type. Sub-classes must override it to return 'this'
    public abstract T thisSub();

    //and a setter and getter for the ComponentRenderer
}

// Here the self-type parameter is set
class GuiButton extends GuiComponent<GuiButton> {
    public GuiButton(/* ... */) {
        //...
        this.setComponentRenderer(new FlatButtonRenderer());
    }

    class FlatButtonRenderer implements ComponentRenderer<GuiButton> {
        @Override
        public void draw(final GuiButton component) {
            //...
        }
    }

    @Override
    public GuiButton thisSub() {
        return this;
    }
}