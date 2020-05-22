public class JsTextTableCell<S,T> extends javafx.scene.control.TableCell<S, T> {

    public void setText(Object text){
        System.out.println("In java, calling setText(" + text.toString() + ")");
        super.setText(text.toString());
    }
}