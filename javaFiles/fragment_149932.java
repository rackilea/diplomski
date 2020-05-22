import javax.swing.JComponent;
import javafx.ext.swing.SwingComponent;

class NewFxComponent extends SwingComponent
{ 

    var comp: JComponent;

    public override function createJComponent():JComponent
    {
        return new OldJComponent();
    }

}