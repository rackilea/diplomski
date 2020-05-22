import com.sun.faces.renderkit.html_basic.MenuRenderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *  @link https://stackoverflow.com/questions/27324024/jsf-selectonemenu-extending-menurenderer-for-displaying-a-plain-text-when-there/27337240#27337240
 */
public class SelectRenderer extends MenuRenderer {
    @Override
    protected void renderSelect(FacesContext context, UIComponent component) throws IOException {
        final ResponseWriter originalResponseWriter = context.getResponseWriter();
        context.setResponseWriter(new AditionalAttributesWritter(originalResponseWriter));
        super.renderSelect(context, component);
        context.setResponseWriter(originalResponseWriter); // Restore original writer.
    }
}