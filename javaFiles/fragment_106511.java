public interface SomeInterface {
    public void save();
}

public class GUI implements SomeInterface {
    Popup popup = new Popup(this);

    @Override
    public void save() {
        // save
    }
}

public class Popup ...{
    private SomeInterface someInf;

    public Popup(SomeInterface someInf) {
        this.someInf = someInf;
    }
    ...
    public void actionPerformed(ActionEvent e) {
        someInf.save();
    }
}