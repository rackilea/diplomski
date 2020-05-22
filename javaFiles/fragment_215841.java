import java.math.BigDecimal;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Use via e.g.:
 * <pre>
 * &lt;h:outputText value="#{EL}"&gt;
 *  &lt;f:converter id="com.edsi.jsf.RoundHalfUp"/&gt;
 *  &lt;f:attribute name="decimalPlaces" value="2"/&gt;
 * &lt;/h:outputText&gt;
 * <pre>
 * @author Esmond Pitt
 */
@FacesConverter(value="com.edsi.jsf.RoundHalfUp")
public class RoundHalfUpConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        BigDecimal  bd = (BigDecimal)value;
        int decimalPlaces;
        try
        {
            decimalPlaces = Integer.parseInt((String)component.getAttributes().get("decimalPlaces"));
        }
        catch (Exception exc)
        {
            decimalPlaces = 2;  // or whatever
        }
        return bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP).toString();
    }

}