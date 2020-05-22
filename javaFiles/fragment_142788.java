@XmlRootElement 
public class Root 
{ 
  private String name; 
  private int    junk; 

  @XmlJavaTypeAdapter(MapAdapter.class) 
  private Map<String, Boolean> lights; 

  public Root() 
  { 
    name = ""; junk = 0; lights = new HashMap<String, Boolean>(); 
  } 

  public void   setName(String newName)  { name = newName; } 
  public String getName()                { return name; } 

  public void setJunk(int newJunk)  { junk = newJunk; } 
  public int  getJunk()             { return junk; } 

  public void turnLightOn(String lightName)   { lights.put(lightName, true); } 
  public void turnLightOff(String lightName)  { lights.put(lightName, false); } 
} 

class MapAdapter extends XmlAdapter<MapElements[], Map<String, Boolean>> 
{ 
  public MapElements[] marshal(Map<String, Boolean> arg0) throws Exception 
  { 
    MapElements[] mapElements = new MapElements[arg0.size()]; 

    int i = 0; 
    for (Map.Entry<String, Boolean> entry : arg0.entrySet()) 
      mapElements[i++] = new MapElements(entry.getKey(), entry.getValue()); 

    return mapElements; 
  } 

  public Map<String, Boolean> unmarshal(MapElements[] arg0) throws Exception 
  { 
    Map<String,Boolean> r = new HashMap<String,Boolean>(); 
    for(MapElements mapelement : arg0) 
      r.put(mapelement.key, mapelement.value); 
    return r; 
  } 
} 

class MapElements 
{ 
  @XmlElement public String  key; 
  @XmlElement public Boolean value; 

  private MapElements() {} //Required by JAXB 

  public MapElements(String key, Boolean value) 
  { 
    this.key   = key; 
    this.value = value; 
  } 
}