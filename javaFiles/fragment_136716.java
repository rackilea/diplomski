import javax.xml.bind.annotation.XmlRootElement;

    /**
     *
     * @author Aj
     * This class forms the format of the JSON request which will be recieved from the App
     */
    @XmlRootElement
    public class jsonFormat {
        public double longitude;
        public double latitude;
        public long IMSI;

        jsonFormat(){}

        jsonFormat(double longitude,double latitude, long IMSI){
            this.longitude = longitude;
            this.latitude = latitude;
            this.IMSI = IMSI;
        }

    }