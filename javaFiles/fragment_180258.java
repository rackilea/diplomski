import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.ResponseWriter;
import javax.faces.context.ResponseWriterWrapper;

/**
 * @link https://stackoverflow.com/a/7886942/4253946
 */
public class AditionalAttributesWritter extends ResponseWriterWrapper {
    private static final String[] ATTRIBUTES = { "data-toggle" };
    private ResponseWriter originalResponseWriter;

    public AditionalAttributesWritter(ResponseWriter originalResponseWriter) {
        super();
        this.originalResponseWriter = originalResponseWriter;
    }

    @Override
    // As of JSF 1.2 this method is now public.
    public ResponseWriter getWrapped() {
        return originalResponseWriter;
    }

    @Override
    public void startElement(String name, UIComponent component) throws IOException {
        super.startElement(name, component);
        for (String attribute : ATTRIBUTES) {
            Object value = component.getAttributes().get(attribute);
            if (value != null) {
                super.writeAttribute(attribute, value, attribute);
            }
        }
    }
}