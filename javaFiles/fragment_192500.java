import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;

@JavaScript({ "myscript.js", "https://maps.googleapis.com/maps/api/js?v=3.exp"})
@StyleSheet({ "mystyle.css" })

//Extend AbstractJavaScriptComponent
public class Map extends AbstractJavaScriptComponent {

    float param1=123;
    float param2=456;
    public Map() {
       callFunction("myfunction",param1,param2); //Pass parameters to your function
    }

}