@FacesConverter(value = "generalCollDTOConverter", forClass = GeneralCollDTOConverter.class)
public class GeneralCollDTOConverter  implements Converter {

  private static Map<Object, String> entities = new HashMap<Object, String>();

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    synchronized (entities) {
        if (!entities.containsKey(value)) {
            String uuid = UUID.randomUUID().toString();
            entities.put(value, uuid);
            return uuid;
        } else {
            return entities.get(value);
        }
    }
  }

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    for (Entry<Object, String> entry : entities.entrySet()) {
        if (entry.getValue().equals(value)) {
            System.out.println("getKey:" + entry.getKey());
            return entry.getKey();
        }
    }
    return value;
  }
}