@XmlRootElement(name="MapWrapper")
    public class MapWrapper implements Serializable{

        private static final long serialVersionUID = 1L;


        private Map<Long, String> yourMap;


        public Map<Long, String> getYourMap() {
            return yourMap;
        }

        public void setYourMap(Map<Long, String> yourMap) {
            this.yourMap= yourMap;
        }

    }