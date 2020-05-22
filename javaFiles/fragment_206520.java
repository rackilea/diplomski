public class MapAdapter extends XmlAdapter<MapWrapper, Map<String, String>>{

    @Override
    public Map<String, String> unmarshal(MapWrapper v) throws Exception {
        Map<String, String> map = new HashMap<String,String>();//v.toMap();

        return map;
    }

    @Override
    public MapWrapper marshal(Map<String, String> m) throws Exception {
        MapWrapper wrapper = new MapWrapper();

        for(Map.Entry<String, String> entry : m.entrySet()){
             wrapper.addEntry(new JAXBElement<String>(new QName(entry.getKey()), String.class, entry.getValue()));
        }

        return wrapper;
    }

}