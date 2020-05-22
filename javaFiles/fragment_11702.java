import javax.faces.convert.Converter;
...
@FacesConverter("FooConverter")
public class FooConverter implements Converter{
  @Override
  public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
    someHashMap.get(value);
  }
  @Override
  public String getAsString(FacesContext context, UIComponent component,
            Object value) {
    // convert from Object to String
   }    
}