public class MyView extends VerticalLayout implements View {

    private UI ui;

    @Override
    public onAttach() {
        ui = getUI();
        ...
    }

...

    public updateMe(..) {
        ...
        try {
           ui.access( ... do updates ... );
        } catch (UIDetachedException e) {
           // Do nothing, this exception is thrown if Browser is closed
        }
    }
}