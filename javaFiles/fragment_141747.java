package my;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import com.sun.faces.renderkit.html_basic.TextRenderer;

public class HtmlCustomRenderer extends TextRenderer {

    @Override
    public String getCurrentValue(FacesContext context, UIComponent component) {

        if (component instanceof UIInput) {
            Object submittedValue = ((UIInput) component).getSubmittedValue();
            if (submittedValue != null) {
                // value may not be a String...
                return submittedValue.toString();
            }
        }

        String currentValue = null;
        Object currentObj = getValue(component);
        //Remove the 'if' to call getFormattedValue even if null
        currentValue = getFormattedValue(context, component, currentObj);
        return currentValue;

    }

}